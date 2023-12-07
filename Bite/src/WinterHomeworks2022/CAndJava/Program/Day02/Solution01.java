package WinterHomeworks2022.CAndJava.Program.Day02;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 15:22
 * Description 小算法 => 完全数 => 如果是求因数,遍历时可利用平方根减少遍历次数
 * 1.题目: 编程求 1~10000 之间的所有“完全数”，完全数是该数的所有因子之和等于该数的数。例如，6 的因子有 1、2、3，
 * 且 6=1+2+3，所以 6 是完全数。(1不是完全数(题目有责任给出这个信息))
 */
public class Solution01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (perfectNumber(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean perfectNumber(int num) {
        //由于按照完全数定义判断1,确实是完全数.但是定义中排除了,
        // 所以程序实现时,就不能用完全数定义来判断1,所以先排除
        if (num == 1) {
            return false;
        }
        int count = 0;
        //找出所有因子,找到就累加起来
        double sqrt = Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                count += i;
                if (i != 1 && i * i != num) {
                    count += num / i;
                }
            }
        }
        if (count == num) {
            return true;
        } else {
            return false;
        }
    }
}
