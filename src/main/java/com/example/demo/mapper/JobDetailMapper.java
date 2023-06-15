package com.example.demo.mapper;

import com.example.demo.dto.JobAndTriggerDto;
import com.example.demo.pojo.JobDetail;
import com.example.demo.pojo.JobDetailKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface
JobDetailMapper {
    int deleteByPrimaryKey(JobDetailKey key);

    int insert(JobDetail record);

    int insertSelective(JobDetail record);

    JobDetail selectByPrimaryKey(JobDetailKey key);

    int updateByPrimaryKeySelective(JobDetail record);

    int updateByPrimaryKeyWithBLOBs(JobDetail record);

    int updateByPrimaryKey(JobDetail record);

    List<JobAndTriggerDto> getJobAndTriggerDetails();
}