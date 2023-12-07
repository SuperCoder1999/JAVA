package chapter19IO.homeworks;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("e:/ok.txt"));
        String readLine = null;
        int lineNum = 1;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(lineNum++ + " " + readLine);
        }
    }
}
