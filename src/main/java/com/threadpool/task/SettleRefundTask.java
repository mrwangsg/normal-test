package com.threadpool.task;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @创建人 sgwang
 * @name SettleRefundTask
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
@Component
@Scope("prototype")
public class SettleRefundTask implements Callable<Integer> {
    @Resource(name = "settleRefund")
    ThreadPoolTaskExecutor threadPoolTask;

    private String uniqueNo;
    private String name;

    public SettleRefundTask(String uniqueNo, String name) {
        this.uniqueNo = uniqueNo;
        this.name = name;
    }

    @Override
    public Integer call() {
        System.err.println("threadPoolTask: " + threadPoolTask + ", name: " + name);
        try {
            System.err.println("id:" + Thread.currentThread().getId()
                    + "   name:" + Thread.currentThread().getName() + " start -> uniqueNo: " + this.uniqueNo);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }
}
