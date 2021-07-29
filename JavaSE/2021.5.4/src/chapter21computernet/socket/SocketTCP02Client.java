package chapter21computernet.socket;

/*
    应用案例：
    1. 编写一个服务器，和一个客户端
    2. 服务器端在9999端口监听
    3. 客户端连接到服务器，发送“hello,server"，并接收服务器端回发的”hello,client"，在退出
    4. 服务器端接收到客户端发送的消息，输出，并发送client，再退出

    注意：每一条数据都要有结束标记[即使发送单条语句也是]
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        // 设置结束标记
        socket.shutdownOutput();

        // 接收回送的消息
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLine = 0;
        while ((readLine = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLine));
        }

        //关闭所有流
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
