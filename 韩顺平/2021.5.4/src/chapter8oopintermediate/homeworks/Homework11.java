package chapter8oopintermediate.homeworks;

public class Homework11 {
    public static void main(String[] args) {
        /*
        向上转型：
            Person person = new Student();
            person.run();//子类的run方法 / 原因是运行类型是Student
            person.eat();
        向下转型：
            Student student = (Student)person;
            student.run();//子类的run方法
            student.eat();
            student.study();
         */
    }
}

class Person11 {
    public void run() {
        System.out.println("person sun()");
    }

    public void eat() {
        System.out.println("person eat()");
    }
}

class Student extends Person11 {
    public void run() {
        System.out.println("student run() ");
    }

    public void study() {
        System.out.println("student study()");
    }
}