package com.threadpool.handler;

import com.threadpool.exception.BussiException;
import com.threadpool.task.SettleRefundTask;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @创建人 sgwang
 * @name SettleRefundRejectedHandler
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */

public class SettleRefundRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        throw new BussiException("哈哈，你被拒绝啦！！！");
    }
}
