package chapter8oopintermediate.poly.polyparameter;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {
        this.salary = age;
    }

    public int getAnnual() {
        return 12 * salary;
    }
}
