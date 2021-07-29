package chapter21computernet.socket;

/*
    演示：客户端，发送“hello,server"给服务端
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路：
        /*
            1. 链接服务端（ip，端口）
            解读：链接本机的 9999 端口，如果链接成功，返回Socket对象
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2. 链接成功后，生成Socket，通过socket.getOutputStream()得到和socket对象相关的输出对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, world".getBytes());
        //4.关闭流对象和Socket,必须关闭
        outputStream.close();
        socket.close();
    }
}
