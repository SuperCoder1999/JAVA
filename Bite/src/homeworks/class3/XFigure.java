package homeworks.class3;

import java.util.Scanner;

/*
    打印 X 图形
    https://www.nowcoder.com/practice/83d6afe3018e44539c51265165806ee4
 */

public class XFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == j || i + j == n -1)
                    System.out.print("*" + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
