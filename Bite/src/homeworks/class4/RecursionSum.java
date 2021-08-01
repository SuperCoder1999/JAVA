package homeworks.class4;
/*
作业标题
递归求和

作业内容
递归求 1 + 2 + 3 + ... + 10
 */
public class RecursionSum {
    public static void main(String[] args) {
        System.out.println("1+2+3+ ... +10 = " + sum(10));
    }

    public static int sum(int num) {
        if (num <= 1)
            return 1;
        else
            return num + sum(num - 1);
    }
}
