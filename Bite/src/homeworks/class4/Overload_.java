package homeworks.class4;

public class Overload_ {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("sum(12, 10) = " + a.sum(12,10));
        // 格式控制符
        System.out.printf("sum(1.1, 1.2, 1.3) = %.2f" , a.sum(1.1, 1.2, 1.3));
    }
}

class A {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public double sum(double n1, double n2, double n3) {
        return n1 + n2 + n3;
    }
}