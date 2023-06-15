package com.example.demo.controler;

import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.QuartzService;
import com.example.demo.util.DemoResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: CJ
 * @Date: 2021-11-2 11:41
 */
@Slf4j
@RestController
@RequestMapping(path = "/quartz")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    /**
     * 新增定时任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @param tName  触发器名称
     * @param tGroup 触发器组
     * @param cron   cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/addJob")
    public ResponseEntity<Object> addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            quartzService.addjob(jName, jGroup, tName, tGroup, cron);
            return new ResponseEntity<>(DemoResponseCode.OK, "添加任务成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "添加任务失败！");
        }
    }

    /**
     * 暂停任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/pauseJob")
    public ResponseEntity<Object> pausejob(String jName, String jGroup) {
        try {
            quartzService.pausejob(jName, jGroup);
            return new ResponseEntity<>(DemoResponseCode.OK, "暂停任务成功！");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "暂停任务失败！");
        }
    }

    /**
     * 恢复任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/resumeJob")
    public ResponseEntity<Object> resumejob(String jName, String jGroup) {
        try {
            quartzService.resumejob(jName, jGroup);
            return new ResponseEntity<>(DemoResponseCode.OK, "恢复任务成功！");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "恢复任务失败！");
        }
    }

    /**
     * 重启任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @param cron   cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/rescheduleJob")
    public ResponseEntity<Object> rescheduleJob(String jName, String jGroup, String cron) {
        try {
            quartzService.rescheduleJob(jName, jGroup, cron);
            return new ResponseEntity<>(DemoResponseCode.OK, "重启任务成功！");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "重启任务失败！");
        }
    }

    /**
     * 删除任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/deleteJob")
    public ResponseEntity<Object> deletejob(String jName, String jGroup) {
        try {
            quartzService.deletejob(jName, jGroup);
            return new ResponseEntity<>(DemoResponseCode.OK, "删除任务成功！");
        } catch (SchedulerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "删除任务失败！");
        }
    }

    /**
     * 查询任务
     *
     * @param pageNum  页码
     * @param pageSize 每页显示多少条数据
     * @return Map
     */
//    @GetMapping(path = "/queryJob")
//    public ResponseEntity<Object> queryjob(Integer pageNum, Integer pageSize) {
//        PageInfo<JobAndTriggerDto> pageInfo = quartzService.getJobAndTriggerDetails(pageNum, pageSize);
//        Map<String, Object> map = new HashMap<>();
//        if (!StringUtils.isEmpty(pageInfo.getTotal())) {
//            map.put("JobAndTrigger", pageInfo);
//            map.put("number", pageInfo.getTotal());
//            return new ResponseEntity<>(DemoResponseCode.OK, "查询任务成功！");
//        }
//        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "查询任务失败！");
//    }
}
