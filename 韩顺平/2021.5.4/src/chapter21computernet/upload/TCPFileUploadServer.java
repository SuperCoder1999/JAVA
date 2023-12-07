package chapter21computernet.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待链接");
        Socket socket = serverSocket.accept();

        //通过Socket得到输入流
        //并转换为字节 数组
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        //这里 StreamUtils.streamToByteArray()需要InputStream.那么是不是直接传入socket.getInputStream()就可以
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(
                        new FileOutputStream("E:\\OIP-C.jpg"));
        bufferedOutputStream.write(bytes);

        //向客户端回复“收到图片”
        //通过socket获取输出流(字符)
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();//字符流都需要刷新
        socket.shutdownOutput();//设置写入结束标记

        bufferedInputStream.close();
        bufferedOutputStream.close();
        bufferedWriter.close();//关闭回复消息的流
        socket.close();
        serverSocket.close();
    }
}
