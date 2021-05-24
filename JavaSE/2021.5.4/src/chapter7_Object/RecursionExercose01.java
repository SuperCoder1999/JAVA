package chapter7_Object;

/**
 * 请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...求第 n个斐波那契数列的数字
 */

import java.util.Scanner;

public class RecursionExercose01 {
    public static void main(String[] args) {
        int n = 0;
        Scanner myScanner = new Scanner(System.in);
        n = myScanner.nextInt();
        Fibo aFibo = new Fibo();
        int res = aFibo.fiboArray(n);
        //System.out.println("第" + n + "个斐波那契数 = " + res);
        System.out.println(aFibo.peach(1));
    }
}

class Fibo {
    public int fiboArray(int n) {
        if (n <= 2)
            return 1;
        else
            return fiboArray(n - 1) + fiboArray(n - 2);
    }

    public int peach(int day) {
        if (day == 10)
            return 1;
        else
            return (peach(day + 1) + 1 )* 2;
    }
}
