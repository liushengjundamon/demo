package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户mapper
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    int insert(@Param("user") UserEntity entity);

    /**
     * 获取实体
     *
     * @param entity
     * @return
     */
    List<UserEntity> findByWhere(@Param("entity") UserEntity entity);

    /**
     * 检查是否存在该用户名
     *
     * @param userName
     * @return
     */
    int checkForPresence(@Param("userName") String userName);

    /**
     * 修改用户信息
     *
     * @param entity
     * @return
     */
    int update(@Param("user") UserEntity entity);
}
