package com.cyn.demo;

import java.io.*;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/18
 * FileInputStream // 文件的字节输入流
 * FileOutputStream // 文件的字节输出流
 */
public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chenyanan/Downloads/FileStreamTest.txt");
        OutputStream outputStream = null;
        outputStream = new FileOutputStream(file);
        String msg = "hello world !!! test123";
        byte[] msgBytes = msg.getBytes();
        outputStream.write(msgBytes);
        outputStream.close();
    }
}
