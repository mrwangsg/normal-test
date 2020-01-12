package com.threadpool.exception;

import java.util.concurrent.RejectedExecutionException;

/**
 * @创建人 sgwang
 * @name BussiException
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
public class BussiException extends RejectedExecutionException {

    public BussiException() {
        super();
    }

    public BussiException(String message) {
        super(message);
    }
}
