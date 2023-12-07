package WinterHomeworks2022.CAndJava.Program.Day05;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/12 3:25
 * Description 小算法 => 因数之和 => 求因数,使用平方根减少遍历次数
 * 题目: 一对相亲数是指：甲的约数之和等于乙，乙的约数之和等于甲。求1000以内的相亲数。
 */
public class Solution01 {

    public static void main(String[] args) {
        int factorsSum = 0;
        int factorsSum_02 = 0;
        for (int i = 2; i <= 1000; i++) {
            //直接计算出前一个数字的因数之和,这样可以将两层嵌套遍历变成一层
            factorsSum = getFactorsSum(i);
            //如果前一个数字的因数之和,在1000以内,很大可能因数的因数的因数之和等于前一个数字
            // 其中1没必要计算了
            if (factorsSum != 1 && factorsSum <= 1000) {
                factorsSum_02 = getFactorsSum(factorsSum);
                //判断因数的因数之和是否等于前一个数字
                //  i < factorsSum 是用于去重的.因为有两个数字,变换位置也满足条件
                if (factorsSum_02 == i  && i < factorsSum) {
                    System.out.println(i);
                    System.out.println(factorsSum);
                }
            }
        }
    }

    public static int getFactorsSum(int num) {
        int count = 0;
        double sqrt = Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                count += i;
                //这里因数是排除数字本身
                //  sqrt正好是平方根,则不能让它累加两次
                if (i != 1 && i != sqrt) {
                    count += (num / i);
                }
            }
        }
        return count;
    }
}
