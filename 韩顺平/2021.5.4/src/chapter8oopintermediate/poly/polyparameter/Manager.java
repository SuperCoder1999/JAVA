package chapter8oopintermediate.poly.polyparameter;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void manager() {
        System.out.println("经理" + getName() + "is managing");
    }

    @Override
    public int getAnnual() {
        return super.getAnnual() + bonus;
    }
}
