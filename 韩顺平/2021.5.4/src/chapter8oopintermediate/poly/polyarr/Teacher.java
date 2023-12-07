package chapter8oopintermediate.poly.polyarr;

public class Teacher extends Person {
    public int salary;

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String say() {
        return "老师" + super.say() + " " + salary;
    }

    public void teacher() {
        System.out.println(getName() + "正在教学");
    }
}
