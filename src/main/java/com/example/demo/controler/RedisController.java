package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.util.DemoResponseCode;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 设置key
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    @GetMapping(value = "/redisSet")
    public ResponseEntity<Object> redisSet(String key, String value, long time) {
        if (redisUtil.set(key, value, time) == true) {
            return new ResponseEntity<>(DemoResponseCode.OK, "新增成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "新增失败！");
    }

    /**
     * 获取key
     *
     * @param key
     * @return
     */
    @GetMapping(value = "/redisGet")
    public Object redisGet(String key) {
        return redisUtil.get(key);
    }
}
