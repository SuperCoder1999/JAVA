package chapter21computernet.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        char[] buf = new char[8];
        int readLine = 0;
        while ((readLine = inputStreamReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLine));
        }

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello client");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        inputStreamReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
