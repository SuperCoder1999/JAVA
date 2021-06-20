package chapter10oopsenior.codeblock;

/*
    三：构造器补充细节
      1. 构造器前面隐含了super()和调用普通代码块、普通属性的初始化(super在前，代码块和属性按照定义顺序来)

      2. 所以创建一个对象时，在一个类中静态、普通代码块、属性初始化和构造器的调用细节顺序是
        1）由于静态代码块、静态属性是类加载时就调用的。所以一定在构造器及普通代码块和普通属性初始化之前
        2）第二步是构造器，但是构造器中的执行并不是第二个显式出来的
        3）因为构造器最前面隐含了super、调用普通代码块和普通属性的初始化
 */
public class Detail03 {

    public static void main(String[] args) {
        new BBB();//(1)AAA的普通代码块(2)AAA() 构造器被调用(3)BBB的普通代码块(4)BBB() 构造器被调用
    }
}

class AAA { //父类Object
    {
        System.out.println("AAA的普通代码块");
    }

    public AAA() {
        //(1)super()
        //(2)调用本类的普通代码块、调用本类的普通属性的初始化
        System.out.println("AAA() 构造器被调用....");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB的普通代码块...");
    }

    public BBB() {
        //(1)super()
        //(2)调用本类的普通代码块、调用本类的普通属性的初始化
        System.out.println("BBB() 构造器被调用....");
    }
}
