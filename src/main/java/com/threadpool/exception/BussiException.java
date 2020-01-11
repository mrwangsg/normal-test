package com.threadpool.exception;

/**
 * @创建人 sgwang
 * @name BussiException
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
public class BussiException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766971L;

    public BussiException() {
        super();
    }

    public BussiException(String message) {
        super(message);
    }
}
