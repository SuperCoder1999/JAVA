package chapter8oopintermediate.Override;

/*
    一：基本介绍
        方法覆盖（重写）就是子类中一个方法和父类的某个方法的方法名、返回类型、参数列表
            一样，此时就说子类的这个方法覆盖了父类的方法
    二：
        其实属性的重写，就是重新定义一个同名的属性。调用时，首先找编译类型内的，在找父类。所以重写可以扩大为成员的重写.
 */
public class Introduction {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();

        System.out.println(new Student().n1);
        new Student().m2();


        Person p = new Student();
        System.out.println(p.n1);
    }
}

class Animal {
    public void cry() {
        System.out.println("动物叫---");
    }
}

class Dog extends Animal {

    /*
        此处 重写 格式
        1. Dog 是 Animal 的子类
        2. Dog 中的cry方法和Animal的cry方法定义形式一样（方法名、返回类型、参数列表）
        2. 此时 Dog 中的cry方法，重写了Animal的Cry方法
     */
    public void cry() {
        System.out.println("小狗汪汪叫");
    }
}


class Person {
    public int n1 = 100;

    public void m1() {
        System.out.println("父类的public void m1() 方法");
    }
}

class Student extends Person {
    public int n1 = 200;

    public void m2() {
        System.out.println(super.n1);
    }

}