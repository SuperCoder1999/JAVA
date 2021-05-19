package chapter5_control.homework;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        int num;
        Scanner myScanner = new Scanner(System.in);
        num = myScanner.nextInt();
        if (num > 0)
            System.out.println("大于零");
        else if (num == 0)
            System.out.println("等于零");
        else
            System.out.println("小于零");
    }
}
