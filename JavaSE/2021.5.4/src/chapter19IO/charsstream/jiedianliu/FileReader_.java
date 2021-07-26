package chapter19IO.charsstream.jiedianliu;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    // 单个字符读取文件
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            fileReader = new FileReader(filePath);
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 字符数组读取文件
    @Test
    public void fileReader02() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int readLen = 0;

        try {
            fileReader = new FileReader(filePath);
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}