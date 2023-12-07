package chapter23reflection;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/31 16:59
 * Description 测试 通过反射创建对象时,构造器的访问修饰符规则
 */
public class User { //User类
    private int age = 10;
    private String name = "Tom";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    User(int age) {//default 有参构造器
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}
