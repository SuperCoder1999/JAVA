package homeworks.class3;

import java.util.Scanner;

/*
    最大公约数
    求两个正整数的最大公约数
    这里使用的是 辗转相除法 求最大公约数
 */

public class MaxCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), y = scanner.nextInt();
        int a = x, b = y;
        int temp = 0;
        while ( b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        System.out.println(x + " 和 " + y + " 的最大公约数是：" + a);
    }
}
