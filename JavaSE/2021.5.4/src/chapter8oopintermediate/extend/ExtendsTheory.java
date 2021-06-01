package chapter8oopintermediate.extend;

/**
 * 详解继承本质
 */
public class ExtendsTheory {
    // 默认修饰符 可以访问同包下的子类
    public static void main(String[] args) {
        Son son = new Son();// 创建对象时，内存的状态

        //1）首先看子类是否由该属性 并且可以访问，则返回信息
        //2）如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息)
        //3）如果父类没有就重复步骤 3） ，继续找上级父类，直到Object类
        System.out.println(son.name);
        System.out.println(son.age);// 默认修饰符，可以访问本包下的子类
        System.out.println(son.hobby);
        System.out.println(son.getSalary());

        //遇到私有属性之后，就会报错，不会再找上级父类的属性
        //System.out.println(son.score); // 之后还会告诉怎么跳过，访问Grandpa中的score
    }
}
/*
    1. 方法区：加载依次加载 Object Grandpa Father Son 类信息
    2. 堆区：
        1）分配空间（0x11）。
            a. 0x11 空间的第一个部分分配Grandpa类空间:方法区常量池的"大头爷爷"(0x22)地址赋给name、方法区常量池的"旅游"(0x33)地址赋给hobby
            b. 0x11 空间的第二部分分配Father类空间：方法区常量池的"小头爸爸"(0x44)地址赋给name，age被赋值39
            c. 0x11 空间的第三部分分配Son类空间：方法区常量池的"大头儿子"(0x55)地址赋给name
    3. 堆区中分配的空间(0x11)地址赋给 栈中--主栈/主方法中的对象 son
 */

/*
    访问规则：
    1.
        1）首先看子类是否由该属性 并且可以访问，则返回信息
        2）如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息)
        3）如果父类没有就重复步骤 3） ，继续找上级父类，直到Object类
    2. 如果遇到私有的属性、方法，可以通过父类提供公共的方法去访问
        遇到私有属性之后，就会报错，不会再找上级父类的属性


    2.
 */
class Grandpa {
    String name = "大头爷爷";
    String hobby = "旅游";
    private int salary = 10000;
    int score = 9;

    //2. 如果遇到私有的属性、方法，可以通过父类提供公共的方法去访问.(这个方法在对象中调用即可）
    public int getSalary() {
        return salary;
    }
}

class Father extends Grandpa {
    String name = "小头爸爸";
    int age = 39;
    private int score = 90;
}

class Son extends Father {
    String name = "大头儿子";
}