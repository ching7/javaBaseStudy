package com.cyn.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author chenyanan
 * @date 2021/3/30
 * Created by chenyanan on 2021/3/30
 */
public class NioClientDemo {
    public static void main(String arg[]) throws IOException {
        // 1. 连接到服务端

        while(true){
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

            socketChannel.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            buffer.put(s.getBytes());
            buffer.flip();
            // 2. 把 buffer 里面的数据通过 channel 发送出去
            socketChannel.write(buffer);
            buffer.clear();

            socketChannel.close();
        }

    }

}
