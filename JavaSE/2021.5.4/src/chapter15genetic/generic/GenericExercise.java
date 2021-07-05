package chapter15genetic.generic;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee("Jack", 12000, new MyDate(2000, 5, 6)));
        arrayList.add(new Employee("Jack", 20000, new MyDate(2000, 5, 7)));
        arrayList.add(new Employee("Smith", 15000, new MyDate(1989, 7, 13)));

        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                //先对传入的参数进行验证
                try {
                    if (!(o1 instanceof Employee && o2 instanceof Employee))
                        throw new RuntimeException("参数不对");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                int flag = o1.getName().compareTo(o2.getName());
                if (flag != 0)
                    return flag;
                else
                    return o1.getBirthday().compareTo(o2.getBirthday());

            }
        });

        // 迭代器遍历
        Iterator<Employee> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            System.out.println(emp);
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int compareTo(MyDate m2) {
        if (this.year - m2.getYear() != 0)
            return this.year - m2.getYear();
        else if (this.month - m2.getMonth() != 0)
            return this.month - m2.getMonth();
        else
            return this.day - m2.getDay();
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}