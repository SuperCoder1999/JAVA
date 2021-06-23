package chapter10oopsenior.interface_.interfacepoly;

/*
    一：接口 多态参数
    1. 多态参数有两种体现：
     1）传入方法中的参数
    如package chapter10oopsenior.interface_Introduce;中的computer方法就体现了多态参数
     2）创建对象时向上转型 【所以说，继承和接口的多态应该是相同用法】

 */
public class InterfacePolyParameter {
    public static void main(String[] args) {

        //接口的多态体现（向上转型）
        //接口类型的变量 if01 可以指向 实现了IF接口类的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        //继承体现的多态
        //父类类型的变量 a 可以指向 继承AAA的子类的对象实例
        AAAA a = new BBB();
        a = new CCC();
    }
}

interface IF {
}

class Monster implements IF {
}

class Car implements IF {
}

class AAAA {

}

class BBB extends AAAA {
}

class CCC extends AAAA {
}
