package chapter4operator;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        /*Scanner myScanner = new Scanner(System.in);

        // next()遇到空格就停止。使用nextLine() 可以包含空格
        // 但是nextLine() 也有缺陷
        System.out.println("请输入名字：");
        String name = myScanner.next();


        System.out.println("请输入年龄");
        int age = myScanner.nextInt();
        System.out.println("请输入薪水：");
        double sal = myScanner.nextDouble();
        System.out.println("人的信息如下：");
        System.out.println("名字=" + name + " 年龄=" + age
         + " 薪水=" + sal);*/

        //测试无符号右移>>>会移动符号位吗？ 答案是：符号位也会移动
        System.out.println(-2>>>1);
        // 1000 0000 0000 0000 0000 0000 0000 0010 ->
        // 1111 1111 1111 1111 1111 1111 1111 1110 =>
        // 0111 1111 1111 1111 1111 1111 1111 1111 ---- 2,147,483,647(十进制)
    }
}
