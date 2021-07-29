package homeworks.class3;

import java.util.Scanner;

/*
    打印 n*n 的乘法口诀表
 */

public class MultiplicationFormulaTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i*j + "\t\t");
            }
            System.out.println();
        }
    }
}
