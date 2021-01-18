package com.cyn.demo;

import java.io.*;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/18
 * FileReader // 文件的字符输入流；
 * FileWriter // 文件的字符输出流；
 */
public class FileReadWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chenyanan/Downloads/FileReadWriterDemo.txt");
        Writer writer = null;
        writer = new FileWriter(file);
        String msg = "hello world !!! FileReadWriterDemo";
        writer.write(msg);
        writer.flush();
        writer.close();
    }
}
