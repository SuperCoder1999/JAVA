package examination.day15;

import java.util.Scanner;
//判断二进制中含有1的个数
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int res = 0;
            //
            while (n > 0) {
                if (((n % 2) & 1) == 1)
                    res++;
                n /= 2;
            }
            System.out.println(res);
        }
    }
}
