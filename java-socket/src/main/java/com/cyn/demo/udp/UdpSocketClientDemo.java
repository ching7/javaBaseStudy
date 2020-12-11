package com.cyn.demo.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/4/30
 */
public class UdpSocketClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 6666); // 连接指定服务器和端口
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(">>>>");
            String s = scanner.nextLine(); // 读取一行输入
            if (s.equals("bye")) {
                ds.disconnect();
                break;
            }
            // 发送:
            byte[] data = s.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ds.send(packet);
// 接收:
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("resp " + resp);
        }

    }
}
