package chapter7objectorientedprogrammingprimary.ChapterHomeworks;

/*
    定义一个圆类Circle, 定义属性：半径，提供显示圆周长功能的方法，
    提供显示圆面积的方法
 */
public class Homework05 {
    public static void main(String[] args) {
        Circle aCircle = new Circle(3);
        System.out.println("Perimeter= " + aCircle.perimeter()
        + "Area= " + aCircle.area());
        Circle bCircle = new Circle(1);
        System.out.println("Perimeter= " + bCircle.perimeter()
                + "Area= " + bCircle.area());
    }
}

class Circle {
    double PI = 3.14;//Math.PI 就是PI
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double perimeter() {
        return 2 * PI * radius;
    }

    public double area() {
        return PI * radius * radius;
    }
}
