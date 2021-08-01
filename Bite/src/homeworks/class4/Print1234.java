package homeworks.class4;
/*
作业标题
递归打印数字的每一位

作业内容
按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
 */
public class Print1234 {
    public static void main(String[] args) {
        System.out.print("1234 : ");
        print(1234);
    }

    public static void print(int num) {
        if (num > 9)
            print(num / 10);
        System.out.print(num % 10 + " ");
    }
}
