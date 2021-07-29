package homeworks.class3;

/*
    数字 9 出现的次数
    编写程序数一下 1到 100 的所有整数中出现多少个数字9
 */

public class Number9 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            count += has9(i);
        }
        System.out.println(" 1-100共含有：" + count + "个9");
    }

    public static int has9(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 10 == 9)
                count++;
            i /= 10;
        }
        return count;
    }
}
