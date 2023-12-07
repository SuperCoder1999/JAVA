package chapter8oopintermediate.extend.extendcase;

// 其实这些 Test Pupil Graduate 和 Students 类都可以定义在
// 一个 Java 文件中。之所以定义在不同Java文件中，有利于代码阅读性

public class Test {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "smith";
        pupil.age = 7;
        pupil.setScore(90);
        pupil.testing();
        pupil.showInfo();

        System.out.println("==============");
        Graduate graduate = new Graduate();
        graduate.name = "Jack";
        graduate.age = 21;
        graduate.setScore(99);
        graduate.testing();
        graduate.showInfo();
    }
}
