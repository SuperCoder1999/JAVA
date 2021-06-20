package chapter10oopsenior.codeblock;

/*
    二：创建一个对象时，在一个类中静态、普通代码块和构造器的调用顺序是：
    1. 调用静态代码块和静态属性初始化（两者优先级相同，调用顺序看定义顺序）

    2. 调用构造方法
        (虽然构造器比普通代码块先调用，但是在构造器的最前面隐藏有普通代码块和普通属性初始化的调用操作)

    3. 调用普通代码块和普通属性的初始化(两者优先级相同，均按定义顺序来调用)
 */
public class Detail02 {
    public static void main(String[] args) {
        A a = new A();// (1) A 静态代码块01 (2) getN1被调用...(3)A 普通代码块01(4)getN2被调用...(5)A() 构造器被调用
    }
}

class A {
    { //普通代码块
        System.out.println("A 普通代码块01");
    }

    private int n2 = getN2();//普通属性的初始化


    static { //静态代码块
        System.out.println("A 静态代码块01");
    }

    //静态属性的初始化
    private static int n1 = getN1();

    public static int getN1() {
        System.out.println("静态属性初始化：getN1被调用...");
        return 100;
    }

    public int getN2() { //普通方法/非静态方法
        System.out.println("普通属性初始化：getN2被调用...");
        return 200;
    }

    //无参构造器
    public A() {
        System.out.println("A() 构造器被调用");
    }

}