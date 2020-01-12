package com.threadpool;

import com.threadpool.task.SettleRefundTask;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @创建人 sgwang
 * @user shiguang.wang
 * @创建时间 2019/7/3
 * @描述
 */
@SpringBootApplication
@EnableScheduling
public class StartThreadPoolApp {
    public static void main(String[] args) {
        SpringApplication.run(StartThreadPoolApp.class);
    }

}
