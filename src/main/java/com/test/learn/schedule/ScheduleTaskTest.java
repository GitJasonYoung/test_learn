package com.test.learn.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Jason
 * @Description
 * @date 2021/06/30 星期三
 */
@Component
@Slf4j
public class ScheduleTaskTest {

    /**
     * 执行定时任务
     */
    @Scheduled(cron = "0/5 * * * * ?")
    private void schedule01(){
        long start = System.currentTimeMillis();
        try {
//            log.info("定时任务开始执行:{}",start);
            Thread.sleep(5000);
            log.info("定时任务执行完毕:{}",(System.currentTimeMillis()-start)/1000);
        } catch (InterruptedException e) {
            log.warn("Thread sleep exception:{}",e.getMessage());
        }
    }

}
