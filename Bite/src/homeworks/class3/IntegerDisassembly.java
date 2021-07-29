package homeworks.class3;

import java.util.Scanner;

/*
    输出一个整数的每一位
    输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
 */

public class IntegerDisassembly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = count(num) - 1; i >= 0; i--) {
            System.out.print((int)(num / Math.pow(10, i)) + "、");
            num %= (int)Math.pow(10, i);
        }

        System.out.println(func7(9));
        System.out.println(func7(4));
        System.out.println(func7(2));
        System.out.println(func7(1024));
        System.out.println(func7(8));
        System.out.println(func7(100));
        System.out.println(func7(40));

    }

    public static int count(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static boolean func7(int n) {
        while (n >= 4) {
            if (n % 2 == 1)
                return false;
            n /= 2;
        }
        if (n % 2 == 1)
            return false;
        else
            return true;
    }
}
