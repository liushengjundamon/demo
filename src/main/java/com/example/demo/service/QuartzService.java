package com.example.demo.service;

import org.quartz.SchedulerException;

/**
 * @Author: CJ
 * @Date: 2021-11-2 14:20
 */
public interface QuartzService {

    //PageInfo<JobAndTriggerDto> getJobAndTriggerDetails(Integer pageNum, Integer pageSize);

    void addjob(String jName, String jGroup, String tName, String tGroup, String cron);

    void pausejob(String jName, String jGroupe) throws SchedulerException;

    void resumejob(String jName, String jGroup) throws SchedulerException;

    void rescheduleJob(String jName, String jGroup, String cron) throws SchedulerException;

    void deletejob(String jName, String jGroup) throws SchedulerException;
}
