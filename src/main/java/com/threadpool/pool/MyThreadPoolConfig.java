package com.threadpool.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @创建人 sgwang
 * @name MyThreadPoolConfig
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
@Configuration
public class MyThreadPoolConfig {

    @Bean("settleRefund")
    public ThreadPoolTaskExecutor settleRefundThreadPool() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setBeanName("settleRefund");
        threadPool.setThreadNamePrefix("SettleRefund-ThreadPool");

        threadPool.setCorePoolSize(1); // 核心线程数
        threadPool.setMaxPoolSize(1); // 最大线程数
        threadPool.setQueueCapacity(10); // 任务队列最大容量

        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); // 自定义拒绝策略

        threadPool.setKeepAliveSeconds(300); // 线程最大空闲时间，（控制非核心线程）
        threadPool.setAllowCoreThreadTimeOut(false); // 如果核心线程超过空闲时间，是否允许回收(控制核心线程)
        threadPool.setWaitForTasksToCompleteOnShutdown(true); // 等待所有任务执行完毕，再优雅关闭线程池
        threadPool.setAwaitTerminationSeconds(5); // 个人理解为，阻止spring容器关闭时长。以便线程能继续使用容器资源

        // threadPool.setTaskDecorator(); // 任务装饰器 可以强化任务 暂时不需要

        threadPool.initialize();
        return threadPool;
    }

}
