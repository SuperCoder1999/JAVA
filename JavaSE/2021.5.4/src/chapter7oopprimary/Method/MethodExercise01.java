package chapter7oopprimary.Method;

/**
 * 1)	编写类 AA ，第一个方法：判断一个数是奇数 odd 还是偶数, 返回 boolean
 *          根据行、列、字符打印 对应行数和列数的字符，
 * 	        比如：行：4，列：4，字符#,则打印相应的效果
* 		    ####
* 		    ####
* 		    ####
* 		    ####
 */

import java.util.Scanner;

public class MethodExercise01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = 0;
        n = myScanner.nextInt();
        boolean isOdd = true;
        AA aAA = new AA();
        isOdd = aAA.isOdd(n);
        if (isOdd) {
            System.out.println("Odd");
        }
        else
            System.out.println("Even");
        // 分隔符
        System.out.println("---  ---");
        aAA.print(2,4, '#');
    }
}

class AA {
    // 判断奇偶数
    public boolean isOdd(int n) {
        if (n % 2 == 1)
            return true;
        else
            return false;
        // return n % 2 ==1 ? true : false;
        // return n % 2 == 1;
    }
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
