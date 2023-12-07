package chapter19IO.charsstream.jiedianliu;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        new FileReader_().fileReader02();
    }

    // 单个字符读取文件
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            //1. 创建FileReader 对象
            fileReader = new FileReader(filePath);
            //循环读取使用read, 单个字符读取
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
        String filePath = "e:\\note.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int readLen = 0;

        try {
            //1. 创建FileReader 对象
            fileReader = new FileReader(filePath);
            //循环读取使用read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
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