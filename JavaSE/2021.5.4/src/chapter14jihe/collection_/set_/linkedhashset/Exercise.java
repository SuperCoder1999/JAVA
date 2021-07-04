package chapter14jihe.collection_.set_.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Objects;
/*
  Car 类(属性:name,price)，  如果 name 和 price 一样，
  则认为是相同元素，就不能添加。
 */
public class Exercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("小红", 50000));
        linkedHashSet.add(new Car("小兰", 100000));
        linkedHashSet.add(new Car("小红", 50000));
        linkedHashSet.add(new Car("小红", 40000));
        linkedHashSet.add(new Car("小黄", 50000));
        linkedHashSet.add(new Car("小强", 50000));

        System.out.println(linkedHashSet);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}