package com.threadpool.entrance;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @创建人 sgwang
 * @name Entrance
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
@Component
@Scope("prototype")
public class Entrance implements Callable<Integer> {
    @Resource(name = "settleRefund")
    ThreadPoolTaskExecutor threadPoolTask;

    public void test() {
        System.err.println(threadPoolTask.toString());
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
