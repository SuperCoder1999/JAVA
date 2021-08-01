package homeworks.class4;
/*

作业标题
返回的数字之和

作业内容
写一个递归方法，输入一个非负整数，返回组成它的数字之和
 */
public class NumDivisionSum {
    public static void main(String[] args) {
        System.out.println("123各位和 = " + sum(123));
    }

    public static int sum(int num) {
        if (num < 10)
            return num;
        // 其实省略了 else ；return后可以不用else 分隔
        return num % 10 + sum(num / 10);
    }
}
