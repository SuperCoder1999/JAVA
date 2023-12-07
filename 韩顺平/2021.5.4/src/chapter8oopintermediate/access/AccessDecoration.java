package chapter8oopintermediate.access;

/**
 * 访问修饰符：
 * 1. 虽然 默认 修饰符 不能子类访问。但是如果子类和父类在同一包下，则可以访问。
 */
public class AccessDecoration {
    public static void main(String[] args) {
        new GG().hi();
        new GG().he();
    }
}

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