package chapter7oopprimary.Overload;

public class OverloadCase {
    public static void main(String[] args) {
        MyCalculator aMyCalculator = new MyCalculator();
        System.out.println(aMyCalculator.calculator(1, 2));
        System.out.println(aMyCalculator.calculator(1, 2.0));
        System.out.println(aMyCalculator.calculator(1.0, 2));
        System.out.println(aMyCalculator.calculator(1.0, 2.0));

    }
}

class MyCalculator {
    public int calculator(int n1, int n2) {
        return n1 + n2;
    }
    public double calculator(int n1, double n2) {
        return n1 + n2;
    }
    public double calculator(double n1, int n2) {
        return n1 + n2;
    }
    public double calculator(double n1, double n2) {
        return n1 + n2;
    }
}
