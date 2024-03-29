package chapter10oopsenior.interface_;

import com.sun.media.sound.AiffFileReader;


/*
    一：接口概念：
    1. 接口就是给出一些没有实现的方法，到某个类要使用的时候，再根据具体情况
   把这些方法写出来

    二：接口 定义格式
    interface 接口名 {
      属性 接口内可以有属性(其实是隐藏了public 和 static的静态属性)
      方法
    }
     -注意：
        1.Jdk7.0以前接口里的所有方法都没有方法体，即都是抽象方法
        2.Jdk8.0后接口可以有静态方法、默认方法，也就是说接口中可以有方法的具体实现
            默认方法是在有类实现接口的情况下可以调用
            静态方法可以像普通类中的静态方法一样调用

    三：实现接口的格式
    class 类名 implements 接口 {
        自己的属性；
        自己的方法；
        必须实现的接口的抽象方法
        (abstract可以省略，因为抽接口是抽象类的极端情况，
        接口不能有不抽象的方法，它的所有方法都要求也默认是抽象的，所以它不需要在方法前加abstract)
    }
 */
public class InterfaceCase {
    public static void main(String[] args) {
        AInterface.f1();
        System.out.println(AInterface.n1);
        new AA().f2();
    }
}

interface AInterface {
    // 接口内可以有属性(其实是隐藏了public static的静态属性)
    int n1 = 10;

    // 接口内的抽象方法（public abstract可以省略的）
    void h1();// 抽象方法不能用static修饰

    // 在Jdk8.0后接口可以有静态方法、默认方法，也就是说接口中可以有方法的具体实现(都可以省略public)
    static void f1() {
        System.out.println("在Jdk8.0后接口可以有静态方法");
    }

    default public void f2() {
        System.out.println("默认方法");
    }
}

class AA implements AInterface {
    @Override
    public void h1() {
        System.out.println("123");
    }

/*    //@Override//报错
    public static void f1() {
        System.out.println("wode");
    }//静态方法可以重写静态方法，静态方法不能重写普通方法(使用@Override验证发现，不是重写)*/

/*    public void f1() {
        //@Override//报错
        System.out.println("我的");
    } // 不知为何这里普通方法也可以重写静态方法(使用@Override验证发现，不是重写)*/
}

class Father {
    public static void h1() {
        System.out.println("12");

    }
}
class Son extends Father {
    //@Override//报错
    public static void h1() {
        System.out.println("123");
    }//只有静态方法可以重写静态方法(使用@Override验证发现，不是重写)
}
