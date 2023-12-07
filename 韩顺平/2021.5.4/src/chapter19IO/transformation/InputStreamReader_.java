package chapter19IO.transformation;

import java.io.*;


/*
    演示使用 InputStreamReader 转换流解决中文乱码问题
    将字节流 FileInputStream 转成字符流  InputStreamReader, 指定编码 gbk/utf-8

    一：
        转换就是将字节流转换为字符流
    1. InputStreamReader:Reader的子类，可以将InputStream（字节流）包装成（转换成）
    Reader（字节流）[说是包装只因为并没有创建新的流，只是处理时以字符流处理]
    2. OutputStreamWriter:Writer的子类，实现将OutputStream（字节流）
    包装成（转换）Writer（字节流)
    3. 任何文件都可以使用二进制流处理.但是有时需要显示文件的文本内容,此时就要将二进制流转换为字符流
    4. 可以在使用时指定编码格式（比如utf-8\gbk\gb2312,ISO8859-1等）

 */
/**
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流  InputStreamReader, 指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        //GBK编码保存的note.txt
        String filePath = "e:\\note.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();
    }
}