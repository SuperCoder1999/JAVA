package chapter10oopsenior.abstract_;
/*
    一: 细节：
    1. 抽象类不能实例化
    2. 抽象类不一定有抽象方法，抽象类可以没有抽象方法
    3. 一旦类帮喊了abstract方法，则这个类必须声明为abstract
    4. abstract只能修饰类和方法，不能修饰属性或其他的

 */
public class AbstractDetail01 {

    public static void main(String[] args) {
        //抽象类，不能被实例化
        //new A();
    }
}

//抽象类不一定要包含abstract方法。也就是说,抽象类可以没有abstract方法
//，还可以有实现的方法。
abstract class A {
    public void hi() {
        System.out.println("hi");
    }
}

//一旦类包含了abstract方法,则这个类必须声明为abstract
abstract class B {
    public abstract void hi();
}

//abstract 只能修饰类和方法，不能修饰属性和其它的
class C {
    // public abstract int n1 = 1;
}