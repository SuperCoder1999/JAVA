package chapter19IO.bytesstream.jiedianliu;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示使用FileOutputStream 将数据写到文件中,
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile() {

        //创建 FileOutputStream对象
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到 FileOutputStream对象 对象
            //老师说明
            //1. new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容时，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, false);
            //写入一个字节
            //虽然形参类型是int,但是接收过去的int数据会截取最低的1个字节的长度,根据这个一个字节的内容写入数据
            fileOutputStream.write((int)'H');//可以写入
            fileOutputStream.write(255);//可以写入,
            fileOutputStream.write(256);//可以写入
            fileOutputStream.write(257);//可以写入
            fileOutputStream.write(Integer.MAX_VALUE);//可以写入
            //写入字符串
            String str = "hsp,world!";
            //str.getBytes() 可以把 字符串-> 字节数组
            //fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off, int len) 将字节数组中从位于偏移量off的len个字节写入此文件输出流
            即,从offset开始算起的len个字节
             */
            fileOutputStream.write(str.getBytes(), 2, 3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

