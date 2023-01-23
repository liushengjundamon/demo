package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.util.DemoResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        //用户名重复校验
        if (userService.checkForPresence(entity.getUserName()) > 0) {
            return new ResponseEntity<>(DemoResponseCode.EXIST, "用户名已存在！");
        }
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
}
