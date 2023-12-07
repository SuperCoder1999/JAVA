package chapter8oopintermediate.extend.extendexercise;

public class ExtendExercise02 {
    public static void main(String[] args) {
        C02 c02 = new C02();//输出什么
    }
}
/*
    我是A类
    hahaha我是B类的有参构造
    我是c类的有参构造
    我是c类的无参构造
 */

class A02 {//A类

    public A02() {
        // super(); 隐藏
        System.out.println("我是A类"); // 4
    }
}

class B02 extends A02 { //B类,继承A类
    public B02() {
        System.out.println("我是B类的无参构造");
    }

    public B02(String name) {
        // super(); 隐藏 // 3
        System.out.println(name + "我是B类的有参构造"); // 5
    }
}

class C02 extends B02 {   //C类，继承 B类
    public C02() {
        this("hello"); // 1
        // 这里没有隐藏 super();
        System.out.println("我是c类的无参构造"); // 7
    }

    public C02(String name) {
        super("hahaha"); // 2
        System.out.println("我是c类的有参构造"); // 6
    }
}