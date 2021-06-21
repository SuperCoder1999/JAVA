package chapter10oopsenior.abstract_;

public class AbstractExercise02 {
    public static void main(String[] args) {
        Manager wang = new Manager("小王", "1902010160", 20000, 100000);
        wang.work();
        CommonEmployee hong = new CommonEmployee("小红", "10923849", 2000);
        hong.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();

}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("经理 " + super.getName() + " 正在工作中  ");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    public void work() {
        System.out.println("普通员工 " + super.getName() + " 正在工作==");
    }
}