package chapter5control.homework;
/**
 *      判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，
 * 		其各个位上数字立方和等于其本身。
 * 		例如： 153 = 1*1*1 + 3*3*3 + 5*5*5
 */

import java.util.Scanner;

public class Homework04 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("Enter n: ");
        Scanner myScanner = new Scanner(System.in);
        n = myScanner.nextInt();
        int n1 = n / 100;
        int n2 = n / 10 % 10;
        int n3 = n % 10;
        if ((n1 * n1 * n1 + n2 * n2 * n2 + n3 * n3 * n3)==n)
            System.out.println("是水仙花数");
        else
            System.out.println("不是");
    }
}
