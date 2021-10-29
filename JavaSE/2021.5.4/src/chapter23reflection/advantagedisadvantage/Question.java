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
            1.初见眉目：加载是由某种操作触发的(其中较奇怪的操作时找Class对象).而Class类对象创建的时间点
            还不清楚。
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