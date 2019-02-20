<<<<<<< HEAD
package com.suki.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
//        1、使用DatagramSocket  指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
//        2、准备数据 一定转成字节数组
        String data = "上海尚学堂";
        byte[] datas = data.getBytes();
//        3、 封装成DatagramPacket 包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
//        4、发送包裹send​(DatagramPacket p)
        client.send(packet);
//        5、释放资源
        client.close();
    }
}
=======
package com.suki.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
//        1、使用DatagramSocket  指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
//        2、准备数据 一定转成字节数组
        String data = "上海尚学堂";
        byte[] datas = data.getBytes();
//        3、 封装成DatagramPacket 包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
//        4、发送包裹send​(DatagramPacket p)
        client.send(packet);
//        5、释放资源
        client.close();
    }
}
>>>>>>> d5463b07bb2ec6986fc203889d9df4d49622e75b
