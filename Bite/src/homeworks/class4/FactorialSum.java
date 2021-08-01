package homeworks.class4;

public class FactorialSum {
    public static void main(String[] args) {
        System.out.println("1!+2!+3! 的阶乘和 = " + factorialSum(3));
    }

    public static int factorialSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int each = 1;
            for (int j = 1; j <= i; j++) {
                each *= j;
            }
            sum += each;
        }
        return sum;
    }
}
