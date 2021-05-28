package chapter7_ObjectOrientedProgramming.This;

public class ThisDetail {
    public static void main(String[] args) {
        // this的细节：
        // 1.访问成员方法的语法：this.方法名(参数列表);
        // 2.访问构造器语法：this(参数列表);注意只能在构造器中使用，必须放置在第一条语句


        // 1.访问成员方法的语法：this.方法名(参数列表);
        D1 aD1 = new D1();
        aD1.f3();
    }
}

class D1 {

    String name;
    int age;

    // 1.访问成员方法的语法：this.方法名(参数列表);
    public void f1() {
        System.out.println("this.方法名(参数列表)调用方法f1");
    }

    public void f2() {
        System.out.println("在类中直接调用:  f2(); ");
    }

    public void f3() {
        System.out.println("调用同类的其他函数");
        this.f1();//当学到继承，就知道为什么要用this调用方法
        f2();
    }
}

class D2 {

}