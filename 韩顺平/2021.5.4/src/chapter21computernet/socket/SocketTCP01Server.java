package chapter21computernet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    服务端
 */


public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        /*
        思路：
        1. 在本机的9999端口监听，等待链接
            细节：要求在本机上没有其他服务在监听9999端口
            细节：这个ServerSocket 可以通过accept() 返回多个Socket
             即多个客户端链接服务器的并发 的情况(这里错误, 不能并发多个链接, 每次只能和一个client建立链接)
         */
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待链接===");
        //2. 当没有客户端链接9999端口时，程序会 阻塞，等待连接
        // 如果有客户端链接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("客户端 socket返回=" + socket.getClass());

        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();

        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }

        //5. 关闭流和socket\ServerSocket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
