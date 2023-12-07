package chapter19IO.printstream;

import java.io.IOException;
import java.io.PrintStream;

/*
  演示PrintStream （字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        //方式一,手动创建PrintStream
        //可以去修改打印流输出的位置/设备
        PrintStream printStream = new PrintStream("e:\\f1.txt");
        printStream.println("你好");

        //方式二: 使用标准输出流的.因为标准输出流就是使用PrintStream
        PrintStream printStream2 = System.out;// System.out 类型就是 PrintStream
        /*
             public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */
        printStream2.print("john, hello");
        //因为print底层使用的是write , 所以我们可以直接调用write进行打印/输出
        printStream2.write("韩顺平,你好".getBytes());
        printStream2.close();

        //我们可以去修改打印流输出的位置/设备
        //1. 输出修改成到 "e:\\f1.txt"
        //2. "hello, 韩顺平教育~" 就会输出到 e:\f1.txt
        //3. public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out); // native 本地方法，修改了out
        //   }
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("hello, 韩顺平教育~");


    }
}
