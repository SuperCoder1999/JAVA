package chapter8oopintermediate.poly.polyparameter;

public class Worker extends Employee {
    public Worker(String name, int salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("员工 " + getName() + "is working");
    }

    @Override
    public int getAnnual() {
        return super.getAnnual();
    }
}
