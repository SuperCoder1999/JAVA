package chapter14jihe.map_.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new Employee("Smith", 20000, 1));
        hashMap.put(2, new Employee("Milan", 30000, 2));
        hashMap.put(2, new Employee("Smith", 20000, 1));
        hashMap.put(4, new Employee("jack", 300000, 1));
        hashMap.put(5, new Employee("tom", 21000, 2));
        hashMap.put(6, new Employee("milan", 12000, 3));
        // System.out.println(hashMap); 不能算是遍历

        //KeySet方式
        System.out.println("-----   keySet 的 迭代器 方法 -------");
        Set keySet = hashMap.keySet();
        //迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Employee emp = (Employee)hashMap.get(obj);
            if (emp.getSal() > 18000) {
                System.out.println(obj + "-" + hashMap.get(obj));
            }
        }

        //entrySet方法
        System.out.println("----- entrySet 的 迭代器 方法 -------");
        Set entrySet = hashMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry)obj;
            Employee emp = (Employee)entry.getValue();
            if (emp.getSal() > 18000) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }

        //entry 增强for
        System.out.println(" ----------  entrySet 的 增强for ------");
        Set entrySet1 = hashMap.entrySet();
        for (Object obj : entrySet1) {
            Map.Entry entry = (Map.Entry)obj;
            Employee emp = (Employee)entry.getValue();
            if (emp.getSal() > 18000) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}