package chapter19IO.standard;

import java.util.Scanner;

public class Case {
    public static void main(String[] args) {

        //System 类 的 public final static InputStream in = null;  -  创建出来的对象是指 in
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream
        // 表示的是标准输入 键盘
        // 传统方法System.out.println 是使用out对象将数据输出到显示器
        System.out.println(System.in.getClass());

        //老韩解读
        //1. System.out public final static PrintStream out = null; -- 对象是指 out
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream
        //4. 表示标准输出 显示器
        System.out.println(System.out.getClass());

        System.out.println("hello, 韩顺平教育~");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);


    }
}