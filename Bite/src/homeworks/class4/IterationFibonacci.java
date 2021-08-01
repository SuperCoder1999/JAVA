package homeworks.class4;

import java.util.Scanner;

/*
        作业标题
        斐波那契数
        作业内容
        求斐波那契数列的第n项。(迭代实现
 */
public class IterationFibonacci {
    public static void main(String[] args) {
        int b1 = 1, b2 = 1;
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int result = 1;
        if (n <= 2) {
            System.out.println("第" + n + "项Fibonacci = " + result);
            return;
        }
        for (int i = 3; i <= n; i++) {
            result = b1 + b2;
            b1 = b2;
            b2 = result;
        }
        System.out.println("第" + n + "项Fibonacci = " + result);
    }
}
