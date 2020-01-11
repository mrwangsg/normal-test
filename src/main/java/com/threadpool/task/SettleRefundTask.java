package com.threadpool.task;

import java.util.concurrent.Callable;

/**
 * @创建人 sgwang
 * @name SettleRefundTask
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
public class SettleRefundTask implements Callable<Integer> {
    private final String uniqueNo;

    public SettleRefundTask(String uniqueNo) {
        this.uniqueNo = uniqueNo;
    }

    @Override
    public Integer call() throws Exception {
        try {
            System.err.println("id:" + Thread.currentThread().getId()
                    + "   name:" + Thread.currentThread().getName() + " start -> uniqueNo: " + this.uniqueNo);
            System.err.println("id:" + Thread.currentThread().getId()
                    + "   name:" + Thread.currentThread().getName() + " end -> uniqueNo: " + this.uniqueNo);
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }
}
