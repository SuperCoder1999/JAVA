package chapter21computernet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/*
     应用案例：（需使用字符流）
    1. 编写一个服务器，和一个客户端
    2. 服务器端在9999端口监听
    3. 客户端连接到服务器，发送“hello,server"，并接收服务器端回发的”hello,client"，在退出
    4. 服务器端接收到客户端发送的消息，输出，并发送client，再退出

    方法：
    1. socket.getOutputStream()
    2. 将OutputStream -> Writer
    3. 这里需要使用转换流：OutputStreamWriter(字节流)

    注意：这时设置结束标记可以选择writer.newLine()//换行符
    ,需要注意 在另一端 需要使用readLine()读取数据[这需要连段均使用处理流和转换流]

    对于字符流，必须  flush()
 */


public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("hello server");
        outputStreamWriter.flush();//必须有
        socket.shutdownOutput();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        outputStream.close();
        bufferedReader.close();
        socket.close();
    }
}
