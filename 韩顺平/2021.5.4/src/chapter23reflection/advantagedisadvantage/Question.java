package chapter23reflection.advantagedisadvantage;

import java.util.Scanner;

public class Question {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 2) {
            A a = new A();
        } else {
            Class cls = Class.forName("chapter23reflection.advantagedisadvantage.A");
            //到底Class类的对象是在什么时候创建出来的?创建出来时，对应类是否加载完成?
            /*
            1.初步学完JVM后,大概清楚:
                1)静态加载类,是在编译期间
                2)动态加载类,是执行到对应代码位置时
             */
            //cls.newInstance();
        }
    }
}

class A {
    static {
        System.out.println(123);
    }
}