package chapter7oopprimary.ChapterHomeworks;

/*
    创建一个Employee类，
    属性有(名字，性别，年龄，职位，薪水)， 提供3个构造方法，可以初始化
    (1) (名字，性别，年龄，职位，薪水),
    (2) (名字，性别，年龄) (3) (职位，薪水), 要求充分复用构造器
 */
public class Homework12 {
    public static void main(String[] args) {
        Employee aEmployee = new Employee("Smith", "男", 21, "后端开发", 20000);
        aEmployee.info();
        Employee bEmployee = new Employee("Tom", "男", 20, "实习生", 6000);
        bEmployee.info();
        Employee cEmployee = new Employee("Jack", "男", 35, "架构师", 50000);
        cEmployee.info();
    }
}

class Employee {

    String name;
    String gender;
    int age;
    String position;
    double salary;

    // 应该先把参数少的构造器 定义了

    //第一个构造器
    public Employee(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //第二个构造器
    public Employee(String position, double salary) {
        // 这个也可以被第三个构造器复用，不过不能和第一个构造器同时在第三个中复用
        this.position = position;
        this.salary = salary;
    }

    //第三个构造器
    public Employee(String name, String gender, int age, String position, double salary) {
        this(name, gender, age);
        this.position = position;
        this.salary = salary;
    }

    public void info() {
        System.out.println("name:" + name + " gender:" + gender +
                " age：" + age + " position:" + position + " salary:" +
                salary);
    }
}