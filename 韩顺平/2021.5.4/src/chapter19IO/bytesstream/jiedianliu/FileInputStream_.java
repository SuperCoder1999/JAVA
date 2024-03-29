package chapter19IO.bytesstream.jiedianliu;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 演示FileInputStream的使用(字节输入流 文件--> 程序)
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件...
     * 单个字节的读取，效率比较低
     * -> 使用 read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null; //放在外部 用于关闭文件字节流
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);// 这里有编译错误
            /*从该输入流读取一个字节的数据(从输入流中读取数据的下一个字节。)。 如果没有输入可用，此方法将阻止。
            返回结果为 int (但是数据的内容只有1个字节大小)*/
            //如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {// .read()也会报编译错误
                System.out.print((char)readData);//转成char显示,这里读的是字节流,所以不能读文本内容,容易乱码
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();// close()编译错误【如果较真起来，会形成死循环，即
                        //在fileInputStream.close()的try-catch-finally的finally后面再次释放资源 ]
            } catch (IOException e) {// 这里有两处异常，所以使用父类异常处理
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节.
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//显示内容 (这个String 方式值得记住)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
