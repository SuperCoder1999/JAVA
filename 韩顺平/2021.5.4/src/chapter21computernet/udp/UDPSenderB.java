package chapter21computernet.udp;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        /*和SocketTCPClient相类似。只不过不用等待 链接成功 返回 socket对象。而是自己创建 socket ，假设已经链接
        从datagramSocket.send(datagramPacket);报错即可直到，socket对象的创建其实并没有得到保证。保证其能连接到
        要链接的端口。
         */
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //1. 创建需要输出的内容
        byte[] data = "hello 明天吃火锅~".getBytes();//将字符串转换成字节数组
        //2. 直接将数据 送入网络传输层，指向 对方接口
        DatagramPacket datagramPacket =
                new DatagramPacket(data,data.length, InetAddress.getByName("AppleTree"),9999);
        //data：内容字节数组 , data.length：内容长度 , 主机(IP) , 端口
        //3. 调用发送方法
        datagramSocket.send(datagramPacket);
        //4. 关闭发送完数据 而 正处在 链接的 端口资源
    }
}
