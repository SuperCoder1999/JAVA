package chapter19IO.standard;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
    标准输入输出流
    一. 介绍：
                                类型            默认设备
    System.in    标准输入     InputStream         键盘
    System.out   标准输出     PrintStream        显示器

    二.底层:
    1.标准输入流是二进制流.InputStream其实是基类,真正的运行类型是BufferedInputStream,初始化好了输入路径
    2.标准输出流是字符流.PrintStream的编译类型运行类型都是PrintStream,初始化好了输出路径和字符编码

    三.使用
    2.标准输出/输入流,之所以是标准,是因为底层为他们指定了输出/输入的标准路径
    3.可以改变他们的标准输出/入路径,即通过System.setXx(new File(String));
 *
 */
public class Case {
    public static void main(String[] args) throws IOException {

        //System 类 的 public final static InputStream in = null;  -  创建出来的对象是指 in
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream,底层只是将二进制流BufferedInputStream初始化输入的路径,由用户自己包装成目标编码的字符流即可使用
        // 表示的是标准输入 键盘
        System.out.println(System.in.getClass());//BufferedInputStream
        InputStream inputStream = System.in;

        //使用转换流,将节点流变成字符流(比较低级的包装InputStreamReader,高级的包装像Scanner类,提供自定义分隔符等功能)
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        //使用转换后字符流,进行读取
        char[] buff = new char[1024];
        int len = inputStreamReader.read(buff);
        String s = new String(buff, 0, len);
        System.out.println(s);


        //1. System.out public final static PrintStream out = null; -- 对象是指 out
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream,底层也不知道如何初始化的PrintStream,反正交给用户的时候就已经封装成BufferedWriter字符流了,字符编码由JVM决定.
        //4. 表示标准输出 显示器
        // 传统方法System.out.println 是使用out对象将数据输出到显示器
        PrintStream printStream = System.out;
        System.out.println(printStream.getClass());//PrintStream
        printStream.print("标准输出流");
    }

    //改变标准输出/入路径,通过System.setXx(new PrintStream(String));
    @Test
    public void changeOutput() throws FileNotFoundException {
        System.setOut(new PrintStream("e:\\f1.txt"));
        PrintStream out = System.out;// System.out 类型就是 PrintStream
        out.println("123");
    }

    //标准输入流是二进制流,所以需要自己转换成字符流.转换的方式有很多种,下面是通过Scanner包装类转换
    //Scanner底层首先将二进制流通过InputStreamReader转换成字符流,然后使用这个InputStreamReader
    //Scanner的强大在于他能自定义输入多个内容时的分隔符等
    public void usageOfStandardStream() {
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        String next = scanner.next();
        System.out.println("next=" + next);
    }
}