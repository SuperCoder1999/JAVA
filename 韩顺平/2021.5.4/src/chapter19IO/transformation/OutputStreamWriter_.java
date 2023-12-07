package chapter19IO.transformation;

import java.io.*;

/**
 * 演示 OutputStreamWriter 使用
 * 把FileOutputStream 字节流，转成字符流 OutputStreamWriter
 * 这样，表面上输入的是字符,底层自动将字符转换为二进制,然后由二进制流输出
 * 指定处理的编码 gbk/utf-8/utf8
 *
 * OutputStreamWriter可以用BufferedWriter包装
 */

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\data.txt";
        String charSet = "utf-8";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("OutputStreamWriter in bufferedWriter");

        bufferedWriter.close();
        outputStreamWriter.close();
    }
}
