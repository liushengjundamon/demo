package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.FileService;
import com.example.demo.util.DemoResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 文件
 */
@RestController
@RequestMapping(value = "file")
public class FileControler {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseEntity<Object> file(MultipartFile file, String path) throws IOException {
        System.out.println(file.getOriginalFilename());//文件名
        System.out.println(file.getContentType());//文件类型
        System.out.println(file.getSize());//文件大小
        System.out.println(file.getInputStream());//文件的输入流

        //获得文件上传的路径
        //String path = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        //String path = "F:\\测试文件上传";

        System.out.println(path);
        java.io.File newFile = new java.io.File(path);//由于自定义的实体类和java.io.File重名
        //文件夹不存在则重建
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        //上传
        String fileName = file.getOriginalFilename();
        file.transferTo(new java.io.File(newFile, fileName));

        //将文件上传的url存入数据表中
        System.out.println("文件上传成功");
        //入库路径需要路径+文件名
        String newPath = path + "/" + fileName;
        fileService.addFile(fileName, newPath);//调用service方法 将文件信息插入数据库

        return new ResponseEntity<>(DemoResponseCode.OK, "上传成功！");
    }

    /**
     * 文件下载
     * （将文件以流的形式一次性读取到内存，通过响应输出流输出到前端）
     *
     * @param path
     * @param response
     */
    @GetMapping("/download")
    public void download(String path, HttpServletResponse response) {
        try {
            // 本地测试路径 C:/Users/liush/Desktop/软考密码.txt  F:/测试文件上传/OIM流程.docx
            // path是指想要下载的文件的路径
            File file = new File(path);
            //log.info(file.getPath());
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            //String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            //log.info("文件后缀名：" + ext);

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
