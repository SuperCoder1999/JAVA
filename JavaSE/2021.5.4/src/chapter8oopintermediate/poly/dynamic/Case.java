package chapter8oopintermediate.poly.dynamic;
    /*
    一：动态绑定机制
        1. 当调用对象方法时，该方法会和对象的内存地址/运行类型绑定
        2. 当调用对象属性时，没有动态绑定机制，哪里声明哪里使用
     */
public class Case {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());// 30
            /*
            这里sum函数调用的是A类中的函数。
            A类中sum中的getI是由于动态绑定机制而调用a的运行类型中的getI函数（即子类中的getI）
             */
        System.out.println(a.sum1());//20
            /*
                属性没有动态绑定机制，哪里声明调用哪里的。
                调用时，
                有重写：首先找编译类型内的，在找父类。
                只是在类中调用：先找本类，没有就找父类
             */
    }
}

class AA {
    //int i = 3;//当下面A的 private int i = 10;没有时，a.sum1()会调用AA的 i
}

class A extends AA {
    private int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    private int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
