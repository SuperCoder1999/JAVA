package chapter14jihe.homeworks;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02 {
    public static void main(String[] args) {
        Car a = new Car("宝马", 4000000);
        Car b = new Car("宾利", 5000000);
        Car c = new Car("大奔", 7000000);
        ArrayList arrayList = new ArrayList();

        //1.add:添加单个元素
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        System.out.println("创建完：" + arrayList);

        //* 2.remove:删除指定元素
        arrayList.remove(a);
        System.out.println("remove完：" + arrayList);

        //* 3.contains:查找元素是否存在
        System.out.println("b 是否存在" + arrayList.contains(b));
        System.out.println("a 是否存在" + arrayList.contains(a));

        //* 4.size:获取元素个数
        System.out.println("元素个数=" + arrayList.size());

        //* 5.isEmpty:判断是否为空
        System.out.println("判断ArrayList集合是否为空" + arrayList.isEmpty());

        //* 6.clear:清空
        arrayList.clear();
        System.out.println("删除后 判断ArrayList集合是否为空" + arrayList.isEmpty());

        //* 7.addAll:添加多个元素
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(new Car("玛莎拉蒂", 20000000));
        arrayList1.add(new Car("保时捷", 10000000));
        arrayList1.add(new Car("红旗", 10000000));
        arrayList.addAll(arrayList1);
        ArrayList arrayList2 = arrayList1;//留待删除.这里其实是引用，并没有创建新的空间
        System.out.println("addAll后：" + arrayList1);

    //* 8.containsAll:查找多个元素是否都存在
        System.out.println("是否存在多个元素：" + arrayList1.containsAll(arrayList2));

        //* 9.removeAll：删除多个元素
        arrayList1.removeAll(arrayList2);// arrayList2和arrayList1 一样空了
        System.out.println("removeAll后：" + arrayList1);

        //* 10.增强for
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Car("玛莎拉蒂", 20000000));
        arrayList3.add(new Car("红旗", 10000000));
        System.out.println("-- 增强for ---");
        for (Object obj : arrayList3) {
            Car car = (Car) obj;
            System.out.println(car);
        }

        //* 11.迭代器
        System.out.println("-- 迭代器 ---");
        Iterator iterator = arrayList3.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}