package chapter23reflection.classload_;

/*
    一：说明静态加载和动态加载的概念
    1.静态加载：编译时加载相关的类，如果没有对应类就报错。依赖性太强。
    (从idea中报错的过程来看，代码的编译、加载阶段在写的时候就进行了，这就更不清楚jvm的原理了)
    2.动态加载：运行时加载需要的类，如果运行时不用该类，即使不存在该类也不会报错，降低了依赖性.

    3.类加载的时机
    1.当创建对象时(new)
    2.当子类被加载时，父类也被加载
    3.调用类中的静态成员时
    4.通过反射获取类对象时(准确来说，在找相关类的Class对象时就已经加载了该类了。
    见代码：chapter23reflection.advantagedisadvantage.Question)
 */

import java.util.Scanner;

public class StaticDynamicLoad {
    public static void main(String[] args) throws ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n ==2) {
            //Dog dog = new Dog();静态加载，没有Dog类就报错
        } else {
            Class cls = Class.forName("chapter23reflection.introduction.Cat12138");
            //只在运行到这里时才判断进行加载相关类
        }
    }
}