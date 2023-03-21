package com.example.demo.controler;

import com.example.demo.entity.MailEntity;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.excelVO.UserExcelVO;
import com.example.demo.service.SendMailService;
import com.example.demo.service.UserService;
import com.example.demo.util.DemoResponseCode;
import com.example.demo.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用户信息controler
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SendMailService sendMailService;

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
            //修改成功通知我
            MailEntity mailEntity = new MailEntity();
            mailEntity.setSendTo("liushengjun97@163.com,1132373926@qq.com");
            mailEntity.setText("您的账号(" + entity.getUserId() + ")数据已被更改！，请前往数据库查看。");
            mailEntity.setSubject("账号密码变动提醒");
            sendMailService.sendSimpleMail(mailEntity);
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
     * 导出用户数据
     *
     * @param response
     * @param vo
     */
    @GetMapping(value = "exportExcel")
    public void export(HttpServletResponse response, UserExcelVO vo) {

        //查出要导出的数据
        List<UserExcelVO> list = userService.findUserExcelData(vo);
        //导出操作
        ExcelUtil.exportExcel(list, "用户信息", "账号密码", UserExcelVO.class, "我的账户信息.xls", response);
    }

    /**
     * 导入用户数据
     *
     * @param filePath
     * @return
     */
    @GetMapping("importExcel")
    public ResponseEntity<Object> importExcel(String filePath) {

        //String filePath = "C:\\Users\\liush\\Desktop\\账号.xls";
        //解析excel，
        List<UserExcelVO> list = ExcelUtil.importExcel(filePath, 1, 1, UserExcelVO.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + list.size() + "】行");
        //批量插入数据
        if (userService.batchInsert(list) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "新增成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "新增失败！");
    }
}
