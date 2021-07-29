package chapter21computernet.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        // 客户端链接服务端 9999 ，得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        //创建读取磁盘文件的输入流
        FileInputStream fileInputStream = new FileInputStream("E:\\OIP-C.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //bytes 就是 所读取的文件对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //通过socket获得的输出流，将bytes数据发送到服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);

        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}