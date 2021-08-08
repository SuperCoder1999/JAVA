package chapter21computernet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
    疑问：对于大数据 UDP 怎么接收?
 */

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket 对象，准备在 9999接收数据，即监听9999端口
             //DatagramSocket有个receive()方法 和Socket的accept()方法类似
        DatagramSocket datagramSocket =
                new DatagramSocket(9999);//该方法DatagramSocket(SocketAddress bindaddr)
        //2. 创建DatagramPacket 准备接收数据
        byte[] buf = new byte[1024];//最大容量是64Kb
        DatagramPacket datagramPacket = new DatagramPacket(buf,0, buf.length);
        //3. 调用datagramSocket.receive(datagramPacket)方法接收数据
        /*
             当有数据包发送到 本机的9999端口时，就会接收到数据
             如果没有数据包发送到 本机的9999端口, 就会阻塞等待.
             和 socket.accept()类似
         */
        datagramSocket.receive(datagramPacket);
        /*
            datagramSocket.receive()接收正在监听的接口 所收到的 datagramPacket
            但是通过看DatagramPacket源码发现，其中存放数据的byte[]是每次都重新赋值的。
            所以如果 接受的 datagramPacket 过大怎么 处理？
         */

        //接收完毕，拆包，输出信息
        int length = datagramPacket.getLength();//有疑问，getLength()其实就是 定义的buf.length
        byte[] data = datagramPacket.getData();//将datagramPacket中存储的数据 复制到 data中，其实也可以直接输出
        String str = new String(data,0,length);
        System.out.println(str);
        datagramSocket.close();//关闭监听 的端口资源
    }
}
