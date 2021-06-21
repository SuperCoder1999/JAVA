package chapter10oopsenior.abstract_;

/*
    一：简介：
        当父类的一些方法不能确定时，可以用abstract关键字来修饰该方法，此时这个方法就是抽象方法
      此时必须用abstract来修饰该类，该类就是抽象类

    二：形式：
        public abstract void eat();
        没有方法体

    三：概念：
    1. abstract 修饰一个类，这个类就叫抽象类
    访问修饰符 abstract 类名 {

    }
    2. abstract 修饰的方法，这个方法就叫抽象方法
        访问修饰符 abstract 返回类型 方法名(参数列表);
      注意：没有方法体
    3. 抽象类的价值更多作用于设计，是设计者设计好后让子类继承并实现的
    4. 抽象类，在框架和设计模式常用到
 */
public class Introduce {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //思考：这里eat 这里你实现了，其实没有什么意义
    //即： 父类方法不确定性的问题
    //===> 考虑将该方法设计为抽象(abstract)方法
    //===> 所谓抽象方法就是没有实现的方法
    //===> 所谓没有实现就是指，没有方法体
    //===> 当一个类中存在抽象方法时，需要将该类声明为abstract类
    //===> 一般来说，抽象类会被继承，有其子类来实现抽象方法.
//    public void eat() {
//        System.out.println("这是一个动物，但是不知道吃什么..");
//    }
    public abstract void eat();
}