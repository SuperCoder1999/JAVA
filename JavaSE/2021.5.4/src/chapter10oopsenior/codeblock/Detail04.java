package chapter10oopsenior.codeblock;

/*
    四: 创建子类对象时(含有继承关系)，
        这时静态代码块、静态属性初始化、普通代码块、普通属性初始化、构造方法的调用顺序
       【为什么每次都是从父类开始：因为子类依托于父类的存在，所以父类一定优先加载】
      1. 父类的静态代码块和静态属性初始化（两者同加载而调用，在第一位）
      2. 子类的静态代码块和静态属性初始化
      3. 父类的普通代码块和普通属性初始化（因为子类的super()调用了父类构造器中隐含的普通代码块和普通属性初始化)
      4. 父类构造方法（由于父类构造器中super() 和普通代码块、普通属性初始化都调用过了）
      5. 子类的普通代码块和普通属性初始化（因为子类super()之后隐含的调用）
      6. 子类的构造方法

     五：代码块和普通方法共同特性：
      1. 静态代码块，只能调用静态成员
      2. 普通代码块可以调用任意成员
 */
public class Detail04 {
    public static void main(String[] args) {
        //老师说明
        //(1) 进行类的加载
        //1.1 先加载 父类 A02 1.2 再加载 B02
        //(2) 创建对象
        //2.1 从子类的构造器开始
        //new B02();//对象

        new C02();
    }
}

class A02 { //父类
    private static int n1 = getVal01();

    static {
        System.out.println("A02的一个静态代码块..");//(2)
    }

    {
        System.out.println("A02的第一个普通代码块..");//(5)
    }

    //普通属性的初始化
    public int n3 = getVal02();

    public static int getVal01() {
        System.out.println("父类静态属性初始化：getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("父类普通属性初始化：getVal02");//(6)
        return 10;
    }

    public A02() {//构造器
        //隐藏
        //super()
        //普通代码和普通属性的初始化......
        System.out.println("A02的构造器");//(7)
    }

}

class C02 {
    private int n1 = 100;
    private static int n2 = 200;

    private void m1() {

    }

    private static void m2() {

    }

    static {
        //静态代码块，只能调用静态成员
        //System_.out.println(n1);错误
        System.out.println(n2);//ok
        //m1();//错误
        m2();
    }

    {
        //普通代码块，可以使用任意成员
        System.out.println(n1);
        System.out.println(n2);//ok
        m1();
        m2();
    }
}

class B02 extends A02 { //

    private static int n3 = getVal03();

    static {
        System.out.println("B02的一个静态代码块..");//(4)
    }

    public int n5 = getVal04();

    {
        System.out.println("B02的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("子类静态属性的初始化：getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("子类普通属性的初始化：getVal04");//(8)
        return 10;
    }

    public B02() {//构造器
        //隐藏了
        //super()
        //普通代码块和普通属性的初始化...
        System.out.println("B02的构造器");//(10)
    }
}
