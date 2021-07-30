package homeworks.class3;

/*
    水仙花数
    求出0～999之间的所有“水仙花数”并输出。
    (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，
    如；153＝1＋5＋3?，则153是一个“水仙花数“。）
 */

public class NarcissusNumber {
    public static void main(String[] args) {
        System.out.println("只有1位的数字称为独身数");
        for (int i = 1; i < 1000; i++) {
            // 不能直接对i进行变化
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += Math.pow(num % 10, count(i));
                // 因为复合运算符可以自动强制类型转换，所以没有报错
                // 不同位数的水仙花数 是 不同的次方
                num /= 10;
            }
            if (sum == i)
                System.out.print(i + "\t");
        }
    }
    // 得到该数字是几位数
    public static int count(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
