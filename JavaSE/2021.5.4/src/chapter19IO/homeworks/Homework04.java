package chapter19IO.homeworks;

import java.io.*;

/*
    第二题的变形- 存储编码改成 ANSI 即 gbk
 */

public class Homework04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("e:/ok.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = null;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(readLine);
        }
    }
}
