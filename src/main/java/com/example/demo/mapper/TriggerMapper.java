package com.example.demo.mapper;


import com.example.demo.pojo.Trigger;
import com.example.demo.pojo.TriggerKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TriggerMapper {
    int deleteByPrimaryKey(TriggerKey key);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(TriggerKey key);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKeyWithBLOBs(Trigger record);

    int updateByPrimaryKey(Trigger record);
}