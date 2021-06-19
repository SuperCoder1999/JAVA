package chapter8oopintermediate.homeworks;

public class Homework05 {
    public static void main(String[] args) {
        Worker05 jack = new Worker05("Jack", 5000);
        jack.setSalMonth(12);//由于带薪月份可能更改，所以在创建对象后修改
        jack.printSal();

        Peasant tom = new Peasant("Tom", 3000);
        tom.setSalMonth(8);
        tom.printSal();

        Waiter ming = new Waiter("小明", 3000);
        ming.setSalMonth(5);
        ming.printSal();

        Teacher05 teacher = new Teacher05("小王", 5000);
        // 带薪月份按照默认的给
        teacher.setClassDay(360);
        teacher.setClassSal(100);
        teacher.printSal();

        Scientist sci = new Scientist("老王", 10000);
        // 带薪月份不变
        sci.setBonus(300000);
        sci.printSal();
    }
}

class Person05 {
    private String name;
    private int salMonth = 12;// 带薪月份 , 显式初始化后可以在创建对象后通过set方法修改
    private double sal;// 每月薪资

    public Person05(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void printSal() {
        System.out.println(this.name + " 的工资：" + (salMonth * sal));
    }
}

class Worker05 extends Person05 {
    public Worker05(String name, int salMonth) {
        super(name, salMonth);
    }

    public void printSal() {
        System.out.print("这是工人：");
        super.printSal();// 复用父类的方法
    }
}

class Peasant extends Person05 {
    public Peasant(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("这是农民 ");
        super.printSal();// 复用父类的方法
    }
}

class Waiter extends Person05 {
    public Waiter(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("这是服务员 ");
        super.printSal();
    }
}

class Teacher05 extends Person05 {
    private int classDay;
    private double classSal;

    public Teacher05(String name, double sal) {
        super(name, sal);
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public int getClassDay() {
        return this.classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.print("这是老师 ");
        System.out.println(getName() + " 的工资：" +
                (super.getSalMonth() * super.getSal() + this.classDay * this.classSal));
    }
}

class Scientist extends Person05 {
    private double bonus;

    public Scientist(String name, double sal) {
        super(name, sal);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public void printSal() {
        System.out.print("这是科学家 ");
        System.out.println(super.getName() + " 的工资 : " +
                (super.getSalMonth() * super.getSal() + this.bonus));
    }
}

/*public class Homework05 {
    public static void main(String[] args) {
        System.out.println(new Worker05("Jack", 50000).yearSal());
        System.out.println(new Peasant05("Tom", 40000).yearSal());
        System.out.println(new Teacher05("Smith", 30000, 200, 10).yearSal());
        System.out.println(new Scientist("小明", 100000, 200000).yearSal());
        System.out.println(new Waiter05("小强", 10000).yearSal());
    }
}

class Person05 {
    private String name;
    private double salary;

    public Person05(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double yearSal() {
        return this.salary;
    }
}

class Worker05 extends Person05 {
    public Worker05(String name, double salary) {
        super(name, salary);
    }
}
class Peasant05 extends Person05 {
    public Peasant05(String name, double salary) {
        super(name, salary);
    }
}
class Waiter05 extends Person05 {
    public Waiter05(String name, double salary) {
        super(name, salary);
    }
}
class Teacher05 extends Person05 {
    private int classDay;
    private double classSal;

    public Teacher05(String name, double salary, int classDay, double classSal) {
        super(name, salary);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public double yearSal() {
        return super.yearSal() + (classDay * classSal);
    }
}

class Scientist extends Person05 {
    private double bonus;

    public Scientist(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double yearSal() {
        return super.yearSal() + bonus;
    }
}
*/