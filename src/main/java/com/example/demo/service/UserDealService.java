package com.example.demo.service;

import com.example.demo.entity.UserDealEntity;

/**
 * 交易用户service接口
 */
public interface UserDealService {
    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    int insert(UserDealEntity entity);
}
