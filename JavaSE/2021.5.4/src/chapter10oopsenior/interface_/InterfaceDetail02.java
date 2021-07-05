package chapter10oopsenior.interface_;

/*
    总结规律：类和类 - 继承
            接口和接口 - 继承
            类和接口 - 实现
    二：细节
    5. 一个类同时可以实现多个接口
    6. 接口中的属性,是 public static final（public、static、final可以省略）
    7. 接口中属性的访问形式：接口名.属性名。和静态变量一样
    8. 接口不能继承其它的类,但是可以继承多个别的接口
    9. 接口的修饰符 只能是 public 和默认，这点和类的修饰符是一样的
    10. 接口中 实现接口的类作为 父类，其子类不用再实现接口中的抽象类
 */

public class InterfaceDetail02 {
    public static void main(String[] args) {
        //老韩证明 接口中的属性,是 public static final
        System.out.println(IB.n1);//说明n1 就是static
        //IB.n1 = 30; 说明n1 是 final
    }
}

interface IB {
    //接口中的属性,只能是final的，而且是 public static final 修饰符
    int n1 = 10; //等价 public static final int n1 = 10;

    void hi();
}

interface IC {
    void say();
}

//接口不能继承其它的类,但是可以继承多个别的接口
interface ID extends IB, IC {
}

//接口的修饰符 只能是 public 和默认，这点和类的修饰符是一样的
interface IE {
}

//一个类同时可以实现多个接口
class Pig implements IB, IC {
    @Override
    public void hi() {
    }

    @Override
    public void say() {
    }
}
