package chapter19IO.bytesstream.jiedianliu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    // 创建 File对象 的 方式

    @Test
    // 方法一：new File(String pathname);
    public void create01() {
        String filePath = "e:/new1.text";// 这里文件路径的分隔符可以使用：/ 或 \\ (需要转义)
        File file = new File(filePath);// 这里只是创建在内存中

        try {
            file.createNewFile();//到了这里才是创建文件在硬盘中
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件创建成功");
    }

    // 方式二：new File(File parent, String child);//根据父目录文件+子路径构建
    public void create02() {
        File parentFile = new File("e:\\");
        String fileName = "new2.text";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建成功");
    }

    //方式3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:\\";
        String parentPath = "e:\\";
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
