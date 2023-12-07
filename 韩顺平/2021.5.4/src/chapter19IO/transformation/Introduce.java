package chapter19IO.transformation;

import java.io.*;

/*
    一：引出转换流
    1. 如果文件以 gbk编码方式保存，而BufferedReader默认情况下,读取时的字符编码是JVM决定的.和FileReader一样
    这时就会出现读取错误。
    2. 可以使用转换流，在读取时规定读取的编码方式
 */

public class Introduce {
    public static void main(String[] args) throws IOException {
        //读取e:\\a.txt 文件到程序
        //思路
        //1.  创建字符输入流 BufferedReader [处理流]
        //2. 使用 BufferedReader 对象读取GBK编码保存的note.txt
        //3. 默认情况下，读取文件是按照 JVM的 编码
        String filePath = "e:\\note.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String s = br.readLine();
        System.out.println("读取到的内容: " + s);
        br.close();
    }
}
