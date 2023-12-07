package chapter21computernet.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        // 客户端链接服务端 9999 ，得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        //创建读取磁盘文件的输入流
        FileInputStream fileInputStream = new FileInputStream("src\\chapter21computernet\\upload\\jt.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //bytes 就是 所读取的文件对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);//这个流支持多大的空间？ 

        //通过socket获得的输出流，将bytes数据发送到服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();//不管什么流一定要 设置结束标志

        //接收服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String str = StreamUtils.streamToString(inputStream);
        System.out.println(str);

        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();//关闭接收消息的流
        socket.close();
    }
}