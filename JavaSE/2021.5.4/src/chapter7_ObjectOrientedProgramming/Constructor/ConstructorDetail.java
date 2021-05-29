package chapter7objectorientedprogrammingprimary.Constructor;

public class ConstructorDetail {
    public static void main(String[] args) {
        //1. 一个类可以定义多个不同的构造器，即构造器重载
        //2. 构造器名和类名必须一致
        //3. 构造器没有返回值（甚至是void）
        //4. 构造器是完成对象的初始化，而不是创建对象
        //5. 创建对象时，系统自动调用的该类的对应构造器
        //6. 如果程序员没有定义构造器，系统会自动给类生成一个无参构造器（也称为默认构造器）
        //7. 一旦定义了自己的构造器，默认的构造器就被覆盖，就不能再使用默认无参构造器
            // 除非显式地定义一下

        //1. 一个类可以定义多个不同的构造器，即构造器重载
        Dog aDog = new Dog("Jack");
        System.out.println("第一个构造器初始化的信息：" + aDog.name + " " + aDog.age);
        Dog bDog = new Dog("Tom", 10);
        System.out.println("第二个构造器初始化的信息：" + bDog.name + " " + bDog.age);

        //6. 如果程序员没有定义构造器，系统会自动给类生成一个无参构造器（也称为默认构造器）
        Cat aCat = new Cat();
            // 利用 javap指令 反编译查看隐藏的默认构造器。javap的使用参考文档 D:\桌面\JAVA\韩顺平资料\资料

        //7. 一旦定义了自己的构造器，默认的构造器就被覆盖，就不能再使用默认无参构造器
        // 除非显式地定义一下
        //Cat bCat = new Cat();//此时，调用默认无参构造器出错。

    }
}

class Dog {

    String name;
    int age;

    // 第一个构造器
    public Dog(String dName) {
        name = dName;
    }

    // 第二个构造器
    public Dog(String dName, int dAge) {
        name = dName;
        age = dAge;
    }
}

class Cat {
    String name;
    int age;

    /*
        默认构造器
        Cat() {

        }
     */

    //7. 一旦定义了自己的构造器，默认的构造器就被覆盖，就不能再使用默认无参构造器
    // 除非显式地定义一下
    public Cat(String cName) {
        name = cName;
    }
    // 除非在此显式定义无参构造器
    public Cat() {

    }
}
