package chapter23reflection.introduction;

public class Cat {
    public String name = "招财猫";
    public int age = 10; //public的

    public Cat() {} //无参构造器

    public Cat(String name) {
        this.name = name;
    }

    public void hi() { //常用方法
        System.out.println("hi " + name);
    }
    public void cry() { //常用方法
        System.out.println(name + " 喵喵叫..");
    }

    public void testTime() {};

    static { //常用方法
        System.out.println("Cat类初始化");
    }
}
