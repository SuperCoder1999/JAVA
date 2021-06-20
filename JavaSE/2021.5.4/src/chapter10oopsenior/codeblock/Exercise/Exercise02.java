package chapter10oopsenior.codeblock.Exercise;

/*
    父类静态代码块、静态属性初始化
    子类静态属性初始化              静态成员sam初始化
    子类静态代码块、               static块执行 没有 sam is null


    子类的无参构造器中隐藏super()
    - super() 转到父类构造器中

    构造器中隐藏super() 和 该类普通代码块调用、普通属性初始化

    构造方法                      Sample默认构造函数被调用

    子类的无参构造器中隐藏 该类普通代码块调用、普通属性初始化 sam1成员初始化
    子类构造方法调用                                    Test02默认构造器被调用


 */
public class Exercise02 {
}

class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }
}

class Test02 {
    Sample sam1 = new Sample("sam1成员初始化");//
    static Sample sam = new Sample("静态成员sam初始化 ");//

    static {
        System.out.println("static块执行");//
        if (sam == null) System.out.println("sam is null");
    }

    Test02()//构造器
    {
        System.out.println("Test02默认构造函数被调用");//
    }

    //主方法
    public static void main(String str[]) {
        Test02 a = new Test02();//无参构造器
    }

}
