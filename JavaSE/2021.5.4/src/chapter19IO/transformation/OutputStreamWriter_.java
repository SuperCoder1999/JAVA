package chapter19IO.transformation;

import java.io.*;

/**
 * 演示 OutputStreamWriter 使用
 * 把FileOutputStream 字节流，转成字符流 OutputStreamWriter
 * 这样，就可以 以字节流 但是用字符流的方式 写入 字符.意思是表面上写出的是字符，实则流上传输的是字节
 * 指定处理的编码 gbk/utf-8/utf8
 */

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\data.txt";
        String charSet = "utf-8";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        outputStreamWriter.write("我是帅比");
        outputStreamWriter.close();
    }
}
