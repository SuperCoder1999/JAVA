package chapter8oopintermediate.poly.dynamicbinging;
    /*
    一：动态绑定机制
        1. 当调用对象方法时，该方法会和对象的内存地址/运行类型绑定
        2. 当调用对象属性时
          1. 类外通过创建对象访问属性，看编译类型
          2. 类内方法访问属性，不论带不带this，都是指代方法所在类属性
          (因为在方法中只能使用本类中声明的属性(在本类外可以通过子类对象调用父类属性)。所以子类方法在编译时对于访问父类属性的行为报错)
     */
public class Case {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());// 30
            /*
            对于方法：
            这里sum函数调用的是A类中的函数(先找运行类型B类，发现没有，想上找)。
            A类中sum中的getI是由于动态绑定机制而调用a的运行类型B类中的getI函数（即子类中的getI）
             */
        System.out.println(a.sum1());//20
            /*
            对于属性：
               类内方法访问属性，不论带不带this，都是指代方法所在类属性
          (因为在方法中只能使用本类中声明的属性(在本类外可以通过子类对象调用父类属性)，
          所以子类方法在编译时对于访问父类属性的行为报错，或者通过唯一方式super.属性访问父类属性)
             */
    }
}

class AA {
    int i = 3;
}

class A extends AA {
    private int i = 10;//不存在A类中i未定义的情况，否则下面方法不能声明i变量。只能声明super.i

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
