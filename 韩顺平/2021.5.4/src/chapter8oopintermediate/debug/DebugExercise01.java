package chapter8oopintermediate.debug;

/*
    通过调试体验创建对象的过程
    1. 加载类信息
    2. 创建对象并初始化：默认初始化 -> 显式初始化 -> 构造器初始化
    3. 将对象地址赋给对象名
 */
public class DebugExercise01 {
    public static void main(String[] args) {
        Person jack = new Person("jack", 20);//step into进入构造器，而force step into进入加载类信息
        System.out.println(jack);// step into 进入另一个方法，一直step into 进入toString方法
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}