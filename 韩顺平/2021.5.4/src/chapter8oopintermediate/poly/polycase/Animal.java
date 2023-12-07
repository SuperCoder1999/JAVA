package chapter8oopintermediate.poly.polycase;

public class Animal {
    private String name;

    // 构造器，此处不定义无参构造器了（为了实例的简洁）
    public Animal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}