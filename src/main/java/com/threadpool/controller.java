package com.threadpool;

import com.threadpool.task.SettleRefundTask;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @创建人 sgwang
 * @name controller
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
@RestController
public class controller {
    @Resource(name = "settleRefund")
    ThreadPoolTaskExecutor threadPoolTask;

    @GetMapping
    public void test() {
        doSomeThing();
    }

    @Async("test")
    public void doSomeThing() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();

        System.err.println(threadPoolTask.getThreadNamePrefix());

        try {
            for (int index = 0; index < 1000; index++) {
                threadPoolTask.submit(new SettleRefundTask("index" + index + " T " + minute + ":" + second));
            }
        } catch (TaskRejectedException e) {
            System.err.println(e.getMessage());
        }
    }

}
