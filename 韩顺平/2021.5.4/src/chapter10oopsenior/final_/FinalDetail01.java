package chapter10oopsenior.final_;

/*
    final使用注意事项和细节
    1. final修饰的属性又叫常量，一般用XX_XX_XX来命名
    2. final修饰的属性在定义时，必须赋初值，并且不论是本类的方法中还是创建对象后都不能修改
        赋初值的位置如下：
        1）定义的同时赋值：public final double TAX_RATE = 0.08;
        2）在构造器中
        3）在代码块中(普通代码块，因为静态代码块不能调用非静态属性
    3.如果final修饰的属性是静态的，则初始化的位置只能是
        1）定义时
        2）静态代码块中 不能在构造器和普通代码块中赋值（构造器可能没有被调用）
    4.修饰局部变量,则需要在使用前赋值
    5.final类不能继承，但是可以实例化对象
    6.如果类不是final类但是含有final方法，则该方法虽然不能重写，但是该类可以被继承
 */
public class FinalDetail01 {
    public static void main(String[] args) {
        CC cc = new CC();

        new EE().cal();

        DD dd = new DD();
        dd.cal();
        System.out.println(dd.a);
    }
}

class AA {
    /*
    1. 定义时：如 public final double TAX_RATE=0.08;
    2. 在构造器中
    3. 在代码块中、代码块本质是构造器的一种补充
     */
    public final double TAX_RATE = 0.08;//1.定义时赋值
    public final double TAX_RATE2;
    public final double TAX_RATE3;


    public AA() {//构造器中赋值
        TAX_RATE2 = 1.1;
    }

    {//在代码块赋值
        TAX_RATE3 = 8.8;
    }
    //final修饰的属性在定义时，必须赋初值，并且不论是本类的方法中还是创建对象后都不能修改
    public void f1() {
        //TAX_RATE = 10;
    }
}

class BB {
    /*
    如果final修饰的属性是静态的，则初始化的位置只能是
    1 定义时  2 在静态代码块 不能在构造器中赋值（构造器可能没有被调用）
     */
    public static final double TAX_RATE = 99.9;
    public static final double TAX_RATE2;

    static {
        TAX_RATE2 = 3.3;
    }


}

//final类不能继承，但是可以实例化对象
final class CC {
}


//如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
//即，仍然遵守继承的机制.
class DD {
    public int a = 10;
    public final void cal() {
        this.a = 100;
        System.out.println("cal()方法");
    }
}

class EE extends DD {
}

