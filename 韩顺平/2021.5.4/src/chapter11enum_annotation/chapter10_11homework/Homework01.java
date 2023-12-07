package chapter11enum_annotation.chapter10_11homework;

public class Homework01 {
    public static void main(String[] args) {
        Car c = new Car();
        Car c1 = new Car(100);
        System.out.println(c);//9.0,red
        System.out.println(c1);//100.0,red（注意）

    }
}

class Car {
    double price = 10;
    static String color = "white";
        // 只会在加载时执行一次，修改为red后就不会在执行该条语句了

    public String toString() {
        return price + "\t" + color;
    }

    public Car() {
        this.price = 9;
        this.color = "red";
        // 将共享的静态变量更改了
    }

    public Car(double price) {
        this.price = price;
    }
}