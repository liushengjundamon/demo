package com.example.demo.mapper;

import com.example.demo.entity.UserDealEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 交易用户mapper
 */
@Mapper
@Repository
public interface UserDealMapper {
    /**
     * 新增用户
     *
     * @param entity
     * @return
     */
    int insert(@Param("userDeal") UserDealEntity entity);
}
