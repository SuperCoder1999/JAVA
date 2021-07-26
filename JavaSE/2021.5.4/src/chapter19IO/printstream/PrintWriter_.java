package chapter19IO.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 演示 PrintWriter 使用方式
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        // 打印到显示器
        //PrintWriter printWriter = new PrintWriter(System.out);

        // 打印到文件中
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hi, 北京你好~~~~");
        printWriter.close();//相当于 flush + 关闭流, 才会将数据写入到文件..

    }
}
