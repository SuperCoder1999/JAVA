package chapter10oopsenior.interface_.interfacepoly;

/*
    三：接口中多态传递现象
    1. 接口继承接口的情况
        注意：需要把爷爷接口也实现了
    2. 继承中的多态传递也有相似用法

 */
public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new Teacher();
        //如果IG 继承了 IH 接口，而Teacher 类实现了 IG接口
        //那么，实际上就相当于 Teacher 类也实现了 IH接口.
        //这就是所谓的 接口多态传递现象.
        IH ih = new Teacher();

        Grand grand = new Son();
        grand.f1();//
    }
}

interface IH {
    void hi();
}
interface IG extends IH{ }
class Teacher implements IG {
    @Override
    public void hi() {
    }
}

class Grand {
    public void f1() {
        System.out.println("爷爷");
    }
}

class Father extends Grand{
    public void f2() {
        System.out.println("爸爸");
    }
}

class Son extends Father {
    public void f3() {
        System.out.println("儿子");
    }
}