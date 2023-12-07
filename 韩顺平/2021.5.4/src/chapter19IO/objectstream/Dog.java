package chapter19IO.objectstream;

import java.io.Serializable;

/**
 * @author 韩顺平
 * @version 1.0
 */
//如果需要序列化某个类的对象，实现 Serializable
public class Dog implements Serializable {
    private String name;
    private int age;
    //序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient（转瞬即逝）修饰的成员
    public static String nation = "India";
    private transient String color = "red";
    //序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master("masterInstance");

    //serialVersionUID 序列化的版本号，可以提高兼容性
    //这个功能没有深入研究
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String nation, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", nation=" + nation +
                ", master=" + master +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Master implements Serializable {
    String masterName = null;

    public Master(String masterName) {
        this.masterName = masterName;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterName='" + masterName + '\'' +
                '}';
    }
}