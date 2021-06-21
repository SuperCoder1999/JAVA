package chapter10oopsenior.final_.exercise;

public class Exercise01 {
    public static void main(String[] args) {
        System.out.println(new Circle(3).Area());
        //System.out.println(Circle.Area(3));
    }
}

//class Circle {
//    public final static double PI = 3.14;
//
//    public static double Area(double radius) {
//        return Circle.PI * radius * radius;
//    }
//}



class Circle {
    private double radius;
    private final double PI  = 3.14;

    public Circle(double radius) {
        this.radius = radius;
        //this.PI = 3.14;
    }

//    {
//        this.PI = 3.14;
//    }

    public double Area() {
        return this.PI * this.radius * this.radius;
    }
}


