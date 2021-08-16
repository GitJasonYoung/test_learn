package com.test.learn.schedule;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
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
@JobHandler(value = "XxlJobDemo")
public class XxlJobDemo extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("XxlJob work start");
        return ReturnT.SUCCESS;
    }
}
