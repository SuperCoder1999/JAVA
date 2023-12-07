package chapter12exception.introduce;
import java.io.FileInputStream;
import java.io.IOException;

/*
    编译异常是指在编译期间，就必须处理的异常，否则代码不会通过编译

    常见编译异常：
    SOLException:操作数据库时，查询表肯能发生异常
    IOEException：操作文件时发生的异常
    FileNotFoundException：当操作一个不存在的文件时，发生异常
    ClassNotFoundException：加载类，而该类不存在时，发生异常
    EOFException：操作文件，到文件末尾，发生异常
    IllegalArgumentException：参数异常

    编译时异常的举例：
 */
public class Exception02 {
    public static void main(String[] args) {

        try {
            FileInputStream fis;
            fis = new FileInputStream("d:\\aa.jpg");
            int len;
            while ((len = fis.read()) != -1) {
                System.out.println(len);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}