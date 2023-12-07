package chapter10oopsenior.abstract_;
/*
    二：细节
    5. 抽象类可以有任意成员【抽象类本质还是类】，比如：抽象方法、构造器、静态属性等
    6. 抽象方法不能有主体，即不能实现
    7. 如果一个类继承了抽象类，则必须实现抽象类的所有抽象方法，除非它自己也声明为抽象类
    8. 抽象方法不能使用private、final、static来修饰
        private 修饰的方法，在子类中不能重写
        final 本身就是不能重写的含义
        static 有静态的含义，类加载时就可以用了。而抽象方法没有方法体，所以定义为static就无意义了
    9. 抽象类不能用final修饰
 */
public class AbstractDetail02 {
    public static void main(String[] args) {

        new GG().hi();
        new GG().he();
        System.out.println("hello");
    }
}

//抽象方法不能使用private、final 和 static来修饰，因为这些关键字都是和重写相违背的
//访问修饰符中：默认也能用，只是需要在同一个包中，否则子类访问不到抽象父类的方法；protected可以随便用
abstract class H {
    abstract void hi();//抽象方法

    void he() {
        System.out.println("he");
    }
}

class GG extends H {
    @Override
    void hi() { //这里相等于G子类实现了父类E的抽象方法，所谓实现方法，就是有方法体
        System.out.println("hi");
    }
}

//如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类
abstract class E {
    public abstract void hi();
}

abstract class F extends E {

}

class G extends E {
    @Override
    public void hi() { //这里相等于G子类实现了父类E的抽象方法，所谓实现方法，就是有方法体

    }
}

//抽象类的本质还是类，所以可以有类的各种成员
abstract class D {
    public int n1 = 10;
    public static String name = "韩顺平教育";

    public void hi() {
        System.out.println("hi");
    }

    public abstract void hello();

    public static void ok() {
        System.out.println("ok");
    }
}

// private 修饰的方法，在子类中不能重写
// class AA {
//    private void a() {
//
//    }
//}
//
//class BB extends AA {
//    @Override
//    private void a() {
//    }
//}