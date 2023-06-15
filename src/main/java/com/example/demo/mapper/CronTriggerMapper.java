package com.example.demo.mapper;


import com.example.demo.pojo.CronTrigger;
import com.example.demo.pojo.CronTriggerKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CronTriggerMapper {
    int deleteByPrimaryKey(CronTriggerKey key);

    int insert(CronTrigger record);

    int insertSelective(CronTrigger record);

    CronTrigger selectByPrimaryKey(CronTriggerKey key);

    int updateByPrimaryKeySelective(CronTrigger record);

    int updateByPrimaryKey(CronTrigger record);
}