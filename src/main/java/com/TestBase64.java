package com;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @创建人 sgwang
 * @name TestBase64
 * @user 91119
 * @创建时间 2019/9/3
 * @描述
 */
public class TestBase64 {
    public static void main(String[] args) throws IOException {
        File tmpPath = new File("D:\\tmp\\temp.docx");
        File base64Path = new File("D:\\tmp\\base64.docx");

        FileInputStream fis = new FileInputStream(tmpPath);
        FileOutputStream fos = new FileOutputStream(base64Path);

        byte[] bs = new byte[18 * 1024];
        int count = fis.read(bs);

        String testStr = new String(bs, "ISO-8859-1");
        byte[] deBaseBytes =  testStr.getBytes("ISO-8859-1");

//        byte[] enBaseBytes = Base64.encodeBase64(Arrays.copyOf(bs, count));
//        String tempStr = new String(enBaseBytes, "UTF-8");
//        byte[] deBaseBytes = Base64.decodeBase64(tempStr.getBytes("UTF-8"));

        fos.write(deBaseBytes, 0, count);
    }
}
