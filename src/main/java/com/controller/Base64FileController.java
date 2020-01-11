package com.controller;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

/**
 * @创建人 sgwang
 * @user 91119
 * @创建时间 2019/9/3
 * @描述
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
public class Base64FileController {

    @GetMapping("/index")
    public String index() {
        return "Hello, index!";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("getOriginalFilename: " + file.getOriginalFilename());

        File tmpPath = new File("D:\\tmp\\");
        File tmpFile = new File(tmpPath, file.getOriginalFilename());
        if (!tmpFile.exists()) {
            tmpFile.createNewFile();
        } else {
            tmpFile.delete();
            tmpFile.createNewFile();
        }

        InputStream in = file.getInputStream();
        FileOutputStream fos = new FileOutputStream(tmpFile);
        byte[] bs = new byte[3 * 1024];
        byte[] fileBytes;
        int count;
        while ((count = in.read(bs)) != -1) {
            if (count != bs.length) {
                byte[] copy = Arrays.copyOf(bs, count);
                fileBytes = Base64.encodeBase64(copy);
            } else {
                fileBytes = Base64.encodeBase64(bs);
            }
            fos.write(fileBytes, 0, fileBytes.length);
            fos.flush();
        }


//        System.out.println(new String(Base64.decodeBase64(base64Bytes), "UTF-8"));
//        System.out.println(new String(Base64.decodeBase64(base64Bytes), "ASCII"));
//        System.out.println(new String(Base64.decodeBase64(base64Bytes), "GBK"));
//        System.out.println(new String(Base64.decodeBase64(base64Bytes), "unicode"));
//        file.transferTo(tmpFile);

        return "单文件上传！";
    }

    @RequestMapping("/download")
    public String fileDownload(@RequestParam("fileName") String fileName, HttpServletResponse resp) throws IOException {
        System.out.println(fileName);

        File tmpPath = new File("D:\\tmp\\");
        File downFIle = new File(tmpPath, fileName);
        if (downFIle.exists()) {
            resp.setHeader("content-type", "application/octet-stream");
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            byte[] buff = new byte[5120];
            BufferedInputStream bis = null;
            OutputStream respOs = null;

            respOs = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(downFIle));

            int i = 0;
            while (bis.read(buff) != -1) {
                respOs.write(buff, 0, buff.length);
                respOs.flush();
            }
            bis.close();
        }

        return "下载成功！";
    }

}
