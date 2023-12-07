package chapter19IO.charsstream.jiedianliu;

import java.io.FileReader;
import java.io.IOException;

/**
 * 一: 测试FileWriter和FileReader字符流字符编码是JVM的字符编码
 * 1.JVM的字符编码是通过方法:java.nio.charset.Charset#defaultCharset获得.
 * 2.JVM的字符编码是在JVM启动时确定的.文档说是通过底层系统确定的,但是我只是通过不同的窗口启动JVM,但是都在Windows下
 * 为啥字符编码不一样呢?
 * 二:测试环境:
 * 1.删除这个文件中package信息和中文字符
 * 2.然后到windows的DOS界面运行其字节码文件,可以读出GBK编码的文本文件.而读取不到UTF-8字符
 *
 */
public class FileReader2 {
    public static void main(String[] args) {
        new FileReader2().fileReader02();
    }

    public void fileReader02() {
        String filePath = "e:\\note.txt";
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