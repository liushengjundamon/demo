package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.UserDealEntity;
import com.example.demo.service.UserDealService;
import com.example.demo.util.DemoResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易用户Controller
 */
@RequestMapping(value = "/userDeal")
@RestController
public class UserDealController {

    @Autowired
    private UserDealService userDealService;

    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    @PostMapping(value = "/insert")
    public ResponseEntity<Object> insert(@RequestBody UserDealEntity entity) {

        Assert.hasText(entity.getUserName(), "用户名不能为空！");
        Assert.hasText(entity.getPassword(), "密码不能为空！");

        //用户名重复校验
        if (userDealService.checkRepetition(entity.getUserName()) > 0) {
            return new ResponseEntity<>(DemoResponseCode.EXIST, "用户名已存在！");
        }

        if (userDealService.insert(entity) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "新增成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "新增失败！");
    }

}
