package chapter7objectorientedprogrammingprimary.ChapterHomeworks;

/*
    设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。
    并创建对象，进行测试
 */
public class Homework07 {
    public static void main(String[] args) {
        Dog aDog = new Dog("大黄", "yellow", 2);
        aDog.show();
        Dog bDog = new Dog("小白", "white", .5);
        bDog.show();
    }
}

class Dog {

    String name;
    String color;
    double age;

    public Dog(String name, String color, double age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show() {
        System.out.println("name:" + name + " color:" + color +
                " age=" + age);
    }
}