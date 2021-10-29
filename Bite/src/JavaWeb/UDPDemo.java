package JavaWeb;

import java.io.IOException;
import java.net.*;

/**
 *  演示 UDP协议 下的网络编程
 */

/*
    1.
    public DatagramSocket(int port) throws SocketException {
        this(port, null);
    }
    这个构造器传入的port如果单纯填写接口号，则IP地址默认为 0.0.0.0（这个IP关联所有网卡）
    2.Socket类就是网卡文件对应的抽象类。（因为硬件-网卡就是文件[一切皆文件]）
    3.客户端尽量不绑定端口号
    4.SocketException, UnknownHostException都属于IOException类
 */

public class UDPDemo {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1000],1000, InetAddress.getByName("127.0.0.1"), 999);
    }
}
