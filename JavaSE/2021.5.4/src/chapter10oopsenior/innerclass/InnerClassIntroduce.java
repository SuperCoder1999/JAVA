package chapter10oopsenior.innerclass;

/*
    一：类的五大成员：属性、方法、构造器、代码块、内部类

    二：内部类 的基本介绍
        一个类的内部又完全嵌套另一个类结构。被嵌套的类称为内部类，嵌套它的类称为外部类。
     内部类的最大特点就是可以访问私有属性，并且可以体现类与类之间的包含关系。

    三：基本语法：
    class Outer {//外部类
        class Inner {//内部类
        }
    }
    class Other {//其他类
    }

    四：内部类的分类
    1. 定义在外部类局部位置上【比如方法体、代码块内】
     1）局部内部类（有类名）
     2）匿名内部类（没有类名，重点学习）

    2. 定义在外部类的成员位置
     1）成员内部类（没有static修饰）
     2）静态内部类（有static修饰）

 */
public class InnerClassIntroduce {
    public static void main(String[] args) {

    }
}

class Outer { //外部类
    private int n1 = 100;//属性

    public Outer(int n1) {//构造器
        this.n1 = n1;
    }

    public void m1() {//方法
        System.out.println("m1()");
        //public int n1 = 10;
            //局部变量不能添加修饰符
    }

    {//代码块
        System.out.println("代码块...");
    }

    class Inner { //内部类, 在Outer类的内部

    }
}