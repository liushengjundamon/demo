package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.util.DemoResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用户信息controler
 */
@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserService userService;

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody UserEntity entity) {
        Assert.hasText(entity.getUserName(), "用户名不能为空！");
        Assert.hasText(entity.getPassword(), "密码不能为空！");
        //用户名重复校验（用户名可以重复）
//        if (userService.checkForPresence(entity.getUserName()) > 0) {
//            return new ResponseEntity<>(DemoResponseCode.EXIST, "用户名已存在！");
//        }
        if (userService.insert(entity) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "新增成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "新增失败！");
    }

    /**
     * 条件查询
     *
     * @param entity
     * @return
     */
    @GetMapping("/find")
    public ResponseEntity<Object> findByWhere(UserEntity entity) {
        List<UserEntity> list = userService.findByWhere(entity);
        return new ResponseEntity<>(list);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody UserEntity entity) {
        Assert.hasText(entity.getUserId(), "用户id不能为空！");
        if (userService.update(entity) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "修改成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "修改失败！");
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        if (userService.delete(list) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "删除成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "删除失败！");
    }

    /**
     * 练习Lambda表达式
     *
     * @return
     */
    @GetMapping(value = "/testLambda")
    public ResponseEntity<Object> testLambda() {
        //获取所有数据（返回map）
        List<Map<String, Object>> allData = userService.getAllData();
        List<Map<String, Object>> newAllData = new LinkedList<>();

        //Lambda遍历
        allData.forEach(x -> {
            Map<String, Object> map = new HashMap<>();
            x.forEach((k, v) -> {
                map.put(k, v);
            });
            map.put("Lambda表达式测试", "测试成功！");
            newAllData.add(map);
        });

        return new ResponseEntity<>(newAllData);
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseEntity<Object> file(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());//文件名
        System.out.println(file.getContentType());//文件类型
        System.out.println(file.getSize());//文件大小
        System.out.println(file.getInputStream());//文件的输入流

        //获得文件上传的路径
        //String path = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String path = "F:\\测试文件上传";

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
//        System.out.println("文件上传成功");
//        Date date = new Date();
//        Timestamp time = new Timestamp(date.getTime());//mysql中的日期格式
//        File file1=new File(fileName,path,time);
//        fileService.addFile(file1);//调用service方法 将文件信息插入数据库
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
