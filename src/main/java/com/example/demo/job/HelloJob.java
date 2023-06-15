package com.example.demo.job;

import cn.hutool.core.date.DateUtil;
import com.example.demo.service.QuartzService;
import com.example.demo.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: CJ
 * @Date: 2021-11-2 11:33
 */
@Slf4j
public class HelloJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        QuartzService quartzService = (QuartzService) SpringUtil.getBean("quartzServiceImpl");
        //PageInfo<JobAndTriggerDto> jobAndTriggerDetails = quartzService.getJobAndTriggerDetails(1, 10);
        //logger.info("任务列表总数为：" + jobAndTriggerDetails.getTotal());

        logger.info("任务列表总数为：" + 13579);
        System.out.println("测试成功，洗澡睡觉");
        logger.info("Hello Job执行时间: " + DateUtil.now());
    }
}
