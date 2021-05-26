package chapter7_ObjectOrientedProgramming.Constructor;

public class ConstructorDetail {
    public static void main(String[] args) {
        //1. 一个类可以定义多个不同的构造器，即构造器重载
        //2. 构造器名和类名必须一致
        //3. 构造器没有返回值（甚至是void）
        //4. 构造器是完成对象的初始化，而不是创建对象
        //5. 创建对象时，系统自动调用的该类的对应构造器

        //1. 一个类可以定义多个不同的构造器，即构造器重载
        Dog aDog = new Dog("Jack");
        System.out.println("第一个构造器初始化的信息：" + aDog.name + " " + aDog.age);
        Dog bDog = new Dog("Tom", 10);
        System.out.println("第二个构造器初始化的信息：" + bDog.name + " " + bDog.age);
    }
}

class Dog {

    String name;
    int age;

    // 第一个构造器
    public Dog(String pName) {
        name = pName;
    }

    // 第二个构造器
    public Dog(String pName, int pAge) {
        name = pName;
        age = pAge;
    }
}
