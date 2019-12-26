package com.spongeli.shoppingmall.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/10/21 10:58
 **/
@Component
public class SchedulerTask {
    Logger logger = LoggerFactory.getLogger(SchedulerTask.class);


    /**
     * @Scheduled(fixedRate = 6000)  ：上一次开始执行时间点之后 6 秒再执行。
     * @Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后 6 秒再执行。
     * <p>
     * <p>
     * 每天凌晨1点执行
     */
//    @Scheduled(cron = "0 0 1 * * ?")
    private void cleanUpHistory() {
        logger.info("每天凌晨1点执行任务【开始】");

        logger.info("每天凌晨1点执行任务【结束】");
    }
}