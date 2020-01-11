package com;

import org.apache.commons.codec.CharEncoding;

import java.io.UnsupportedEncodingException;

/**
 * @创建人 sgwang
 * @name TestDecoder
 * @user 91119
 * @创建时间 2019/9/5
 * @描述
 */
public class TestDecoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "中文";
        byte[] bs = input.getBytes("UNICODE");

        System.out.println("最原始的bytes数据：");
        printBytes(bs);
        System.out.println("-----------------");
        printBytes(new String(bs, "gb2312").getBytes("gb2312"));
        printBytes(new String(bs, "gbk").getBytes("gbk"));
        printBytes(new String(bs, "utf-8").getBytes("utf-8"));
        printBytes(new String(bs, "UNICODE").getBytes("UNICODE"));
        printBytes(new String(bs, "ISO-8859-1").getBytes("ISO-8859-1"));
    }

    public static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
