package chapter19IO.bytesstream.buffered;

import java.io.*;

/**
 * 演示使用BufferedOutputStream 和 BufferedInputStream使用
 * 使用他们，可以完成二进制文件拷贝.
 *
 * 思考：字节流可以操作二进制文件，可以操作文本文件吗？当然可以
 */
public class BufferedCopy02 {
    public static void main(String[] args) {

        String srcFilePath = "e:\\sy.jpg";
        String destFilePath = "e:\\sy2.jpg";// 目的地是一个文件而不是目录
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        int readData = 0;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
            while ((readData = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
