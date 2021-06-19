package chapter8oopintermediate.poly.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
        Worker wang = new Worker("小王", 4000);
        Manager zhi = new Manager("大志", 5000, 20000);

        Test test = new Test();
        test.test(wang);
        test.state(wang);
        test.test(zhi);
        test.state(zhi);

    }
}

class Test {
    public void test(Employee e) {
        System.out.println(e.getName() + " " + e.getAnnual());
    }

    public void state(Employee e) {
        if (e instanceof Worker) {
            ((Worker)e).work();
        }
        else if (e instanceof Manager) {
            ((Manager)e).manager();
        }
    }
}
