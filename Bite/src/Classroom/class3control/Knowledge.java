package Classroom.class3control;

/*
    1. switch 中的值 只能是 整数\枚举\字符\字符串
        注意：long 不行
        String 可以
 */

import java.util.Random;
import java.util.Scanner;

public class Knowledge {
    public static void main(String[] args) {

        dividedBy3And5();
        input();

    }

    public static void dividedBy3And5() {
        /*
            找到 1- 100以内能被3和5同时整除的数字
            要求 while 循环、并使用break或continue

        // continue
        int i = 1;
        while (i <= 100) {
            if (i % 15 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
        */

        // break版本
        int i = 0;
        while (true) {
            if (i + 15 > 100)
                break;
            System.out.println(i += 15);
        }
    }

    public static void input() {
        // nextLine() 有时候放在其他next() 下面会导致读入上一行输入的 回车
        // 而导致输入不进去数据。所以nextLine() 最好放在最前面
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        System.out.println(i1);
        String str1 = scanner.nextLine();
        System.out.println(str1);

        /*
            循环读取的方式：
            注意：结束的操作 在idea上是Ctrl + D  CMD 上是 Ctrl + Z
                而在 OJ 上，不用去担心，后台测试会进行结束
         */
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            System.out.println(a);
        }
    }

    public static void random01() {
        /*
            电脑生成随机数字 [1, 100]
            Math.random() 是基本方法。这里是包装方法
         */
        Random random = new Random();
        // new Random(201542) 定义一个随机种子之后，每次运行生成的随机数都是固定的
        int rand = random.nextInt(100);
        //random.nextInt(100) - 结果是[0, 100)
        rand += 1;// 范围是 [1, 101)
        System.out.println(rand);
    }

}
