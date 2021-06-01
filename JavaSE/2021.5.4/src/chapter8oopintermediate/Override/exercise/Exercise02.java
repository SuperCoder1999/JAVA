package chapter8oopintermediate.Override.exercise;
/*
    1.编写一个Person类，包括属性/private（name、age），构造器、方法
      say（返回自我介绍的字符串）
    2.编写一个Student类，继承Person类，增加id、score属性/private，
      以及构造器，定义say方法（返回自我介绍的信息）
    3.在main中，分别创建Person和Student对象，调用say方法输出自我介绍
 */
public class Exercise02 {
    public static void main(String[] args) {
        Person jack = new Person("Jack", 18);
        System.out.println(jack.say());

        Student tom = new Student("Tom", 10, 1902010, 100);
        System.out.println(tom.say());

    }
}

class Person {
    private String name; // 没有特殊情况，属性都是private类型
    private int age;

    public Person() {
        // 这里可以不用 显式定义无参构造器，因为Student之后还会调用父类的一个构造器super(name, age);
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String say() {
        return "姓名：" + name + "  年龄：" + age;
    }
}

class Student extends Person {
    private int id;
    private double score;

    public Student() {

    }
    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
        return super.say() + "  id = " + id + "  score = " + score;// 能复用父类方法的就用
    }
}