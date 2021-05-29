package chapter5control.homework;

/**
 * 求出1-1/2+1/3-1/4…..1/100的和
 */
public class Homework08 {
    public static void main(String[] args) {
        int flag = 1;
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += flag * 1.0 / i;
            flag *= -1;
        }
        System.out.println(sum);
    }
}
