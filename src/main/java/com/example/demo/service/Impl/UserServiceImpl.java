package com.example.demo.service.Impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户信息servcie实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(UserEntity entity) {
        //生成随机用户id
        entity.setUserId(IDGenerator.getPid());
        entity.setCreateDate(new Date());
        return userMapper.insert(entity);
    }

    /**
     * 条件查询
     *
     * @param entity
     * @return
     */
    @Override
    public List<UserEntity> findByWhere(UserEntity entity) {
        return userMapper.findByWhere(entity);
    }

    /**
     * 检查是否存在该用户名
     *
     * @param userName
     * @return
     */
    public int checkForPresence(String userName) {
        return userMapper.checkForPresence(userName);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    public int update(UserEntity entity) {
        return userMapper.update(entity);
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    public int delete(List<String> list) {
        return userMapper.delete(list);
    }
}
