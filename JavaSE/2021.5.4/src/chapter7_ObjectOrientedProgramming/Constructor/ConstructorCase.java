package chapter7_ObjectOrientedProgramming.Constructor;

public class ConstructorCase {
    public static void main(String[] args) {

        Person aPerson = new Person("Jack", 18);
        // 创建对象的同时，初始化对象的属性

        // 查看初始化后的结果
        System.out.println("aPerson的信息如下：" + aPerson.name + " " + aPerson.age);
    }
}

class Person {

    String name;
    int age;

    // 创建 Person的构造器
    public Person(String pName, int pAge) {
        System.out.println("构造器被调用，完成对象属性的初始化");
        name = pName;
        age = pAge;
    }

}
