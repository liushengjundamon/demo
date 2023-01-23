package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

/**
 * 用户信息servcie接口
 */
public interface UserService {
    /**
     * 新增
     *
     * @param entity
     * @return
     */
    int insert(UserEntity entity);

    /**
     * 条件查询
     *
     * @param entity
     * @return
     */
    List<UserEntity> findByWhere(UserEntity entity);

    /**
     * 检查是否存在该用户名
     *
     * @param userName
     * @return
     */
    int checkForPresence(String userName);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(UserEntity entity);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int delete(List<String> list);
}
