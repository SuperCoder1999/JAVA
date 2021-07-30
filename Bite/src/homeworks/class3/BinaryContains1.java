package homeworks.class3;

import java.util.Scanner;

/*
    二进制1的个数
    求一个整数，在内存当中存储时，二进制1的个数。
 */

public class BinaryContains1 {
    public static void main(String[] args) {
        /*
        方法一：和 1 按位与&
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //输入
        int count = 0; // 计数器
        for (int i = 0; i < 16; i++) {
            if (((num >> i) & 1)  == 1) //通过右移，最后一位和1按位与，即可知道最后一位的数字是否是1
                count++;
        }
        System.out.println(num + " 中含有 " + count + " 个 1");
         */

        //方法二 在二进制中每一次减掉一个1，直到减掉所有的1.
        // 是通过：n = n & (n-1)的方式消除最后面的1
        /*
            7：00111
            6：00110
         6&7： 00110 （6）
            5：00101
         5&6： 00100 （4）
            3：00011
          3&4：00000
         */
    }
}

