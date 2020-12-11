package com.cyn.demo.bean;

import java.io.*;

/**
 * 文件描述
 *
 * @ProjectName: java-serializbale
 * @Package: com.cyn.bean
 * @Date 2020/3/19 9:33
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class TestMain {
    public static void main(String[] args) {
//        // 初始化
//        People wanger = new People();
//        wanger.setName("王二");
//        wanger.setAge(18);
//        System.out.println(wanger);
//
//        // 把对象写到文件中
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chenmo"));){
//            oos.writeObject(wanger);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 改变 static 字段的值
//        People.pre ="不沉默";

        // 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("chenmo")));){
            People wanger1 = (People) ois.readObject();
            System.out.println(wanger1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
