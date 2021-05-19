package chapter5_control.homework;

import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {
        int year;
        Scanner myScanner = new Scanner(System.in);
        year = myScanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println("闰年");
        else
            System.out.println("不是闰年");
    }
}
