package homeworks.class3;

import java.util.Scanner;

/*
    二进制序列
    获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
 */

public class BinaryOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] odd = new int[8];
        int[] even = new int[8];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 1)
                even[x++] = (num >> i) & 1;
            else
                odd[y++] = (num >> i) & 1;
        }
        System.out.print("偶数序列：");
        for (int i = 0; i < 8; i++) {
            System.out.print(even[i]);
        }
        System.out.print("\n奇数序列：");
        for (int i = 0; i < 8; i++) {
            System.out.print(odd[i]);
        }
    }
}
