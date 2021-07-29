package chapter21computernet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLine = 0;
        while ((readLine = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLine));
        }

        // 回送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        //关闭流、ServerSocket、Socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        
    }
}
