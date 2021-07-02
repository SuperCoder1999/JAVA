package chapter13commonclass.date;

/*
    说明一下diagram IDEA properties 的含义
    会将set、get后面的字段默认为属性 而显示出来
 */

public class DiagramProperties {

}
 class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void cry() {

    }
    class Air {

    }

    //说明一下diagram IDEA properties 的含义
    //会将set、get后面的字段默认为属性 而显示出来
    public void setAddress(String address) {

    }

    public double getSalary() {
        return 1.1;
    }
}