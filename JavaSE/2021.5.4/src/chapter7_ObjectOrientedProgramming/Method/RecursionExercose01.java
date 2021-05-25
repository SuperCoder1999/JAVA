package chapter7_ObjectOrientedProgramming.Method;

/**
 *
 */

import java.util.Scanner;

public class RecursionExercose01 {
    public static void main(String[] args) {
        int n = 0;
        Scanner myScanner = new Scanner(System.in);
        n = myScanner.nextInt();
        Recursion aRecursion = new Recursion();
        int res = aRecursion.fiboArray(n);
        //System.out.println("第" + n + "个斐波那契数 = " + res);
        System.out.println(aRecursion.peach(1));
    }
}

class Recursion {
    //请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...求第 n个斐波那契数列的数字
    public int fiboArray(int n) {
        if (n <= 2)
            return 1;
        else
            return fiboArray(n - 1) + fiboArray(n - 2);
    }

    /*猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
    以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，
    想再吃时（即还没吃），发现只有1个桃子了。问题：最初共多少个桃子？
    */
    public int peach(int day) {
        if (day == 10)
            return 1;
        else
            return (peach(day + 1) + 1 )* 2;
    }
}
