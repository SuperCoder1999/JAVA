package chapter14jihe.collection_.set_.hashset.exercises;

import java.util.HashSet;
import java.util.Objects;

/*
     定义一个Employee类，该类包含：private成员属性name,age 要求:
     创建3个Employee 对象放入 HashSet中
     当 name和age的值相同时，认为是相同员工, 不能添加到HashSet集合中
 */

public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("milan", 18));
        hashSet.add(new Employee("smith", 18));
        hashSet.add(new Employee("milan", 18));

        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee)obj;
        if (e.getAge() == this.age && e.getName().equals(this.name))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);// 如果name和age都相同，则在计算hashCode()时返回相同结果
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}