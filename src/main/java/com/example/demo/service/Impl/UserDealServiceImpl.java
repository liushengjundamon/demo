package com.example.demo.service.Impl;

import com.example.demo.entity.UserDealEntity;
import com.example.demo.mapper.UserDealMapper;
import com.example.demo.service.UserDealService;
import com.example.demo.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 交易用户service实现类
 */
@Service
public class UserDealServiceImpl implements UserDealService {

    @Autowired
    private UserDealMapper userDealMapper;

    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(UserDealEntity entity) {
        entity.setUserId(IDGenerator.getPid());
        entity.setCreateDate(new Date());
        entity.setUdtDate(new Date());
        return userDealMapper.insert(entity);
    }
}
