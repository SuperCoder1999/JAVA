package chapter19IO.homeworks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\myTemp";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Exists");
        } else if (file.mkdir())
            //file.createNewFile(); 这时创建文件的方法
            System.out.println(filePath + "创建成功");
        else
            System.out.println(filePath + "创建失败");

        File file2 = new File(filePath, "hello.txt");
        if (file2.exists())// 无法写成 if ((File file2 = new File(filePath, "hello.txt")).exists())
            System.out.println("Hello , Exists");
        else {
            new File(filePath, "hello.txt").createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath + "/hello.txt"));
            // 拼接路径是可以的，但是需要 在链接处 添加 /
            bufferedWriter.write("hello world");
            bufferedWriter.close();
        }
    }
}
