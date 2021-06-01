package chapter8oopintermediate.Override;

/*
    一：基本介绍
        方法覆盖（重写）就是子类中一个方法和父类的某个方法的方法名、返回类型、参数列表
            一样，此时就说子类的这个方法覆盖了父类的方法
 */
public class Introduction {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();
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