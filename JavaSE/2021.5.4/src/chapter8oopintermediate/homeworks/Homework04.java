package chapter8oopintermediate.homeworks;

public class Homework04 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 200, 30, 1.2, 500);
        jack.print();
        new Worker("Tom", 150, 30, 1.0).print();
    }
}

class Employee {
    private String name;
    private double daily;
    private int days;
    private double grade;// 父类的属性在子类中不能修改。只能通过创建对象时设置不同的值

    public Employee(String name, double daily, int days, double grade) {
        this.name = name;
        this.daily = daily;
        this.days = days;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void print() {
        System.out.println("salary = " + this.daily * this.days * grade);
    }
}

class Manager extends Employee {

    private double bonus;

    public Manager(String name, double daily, int days, double grade, double bonus) {
        super(name, daily, days, grade);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void print() {
        // super.print(); 重写的时候，可以放弃原本的版本
        System.out.println("经理的salary = " + (getDaily() * getDays() * getGrade() + this.bonus));
            // 这里加减乘除需要加括号才能进行计算
    }
}

class Worker extends Employee {
    public Worker(String name, double daily, int days, double grade) {
        super(name, daily, days, grade);
    }



    @Override
    public void print() {
        System.out.println("工人的");
        super.print();
    }
}
