package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户mapper
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 新增
     *
     * @param entity
     * @return
     */
    int insert(@Param("user") UserEntity entity);

    /**
     * 条件查询
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
     * 修改
     *
     * @param entity
     * @return
     */
    int update(@Param("user") UserEntity entity);

    /**
     * 批量删除
     *
     * @param strings
     * @return
     */
    int delete(@Param("list") List<String> strings);

    /**
     * 获取所有数据（返回map）
     *
     * @return
     */
    List<Map<String,Object>> getAllData();
}