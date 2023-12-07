package WinterHomeworks2022.CAndJava.Program.Day02;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 15:41
 * Description 递归 => 猴子吃桃子,每天吃前一天的一半多一个
 *             => 递归(由于递归适用于知道起始值,并且知道后续变化和起始值关系.这里相反,所以比较绕)
 *
 * 1.题目: 猴子吃桃问题。猴子第一天摘下若干个桃子，当时就吃了一半，还不过瘾，就又吃了一个。第二天又将剩下的
 * 桃子吃掉一半，又多吃了一个。以后每天都吃前一天剩下的一半零一个。到第 10 天在想吃的时候就剩一个桃子了,
 * 求第一天共摘下来多少个桃子？
 */
public class Solution02 {
    public static void main(String[] args) {
        //求倒数第10天数量
        System.out.println(todayCount(10));
    }
    //求倒数第n天的数量
    public static int todayCount(int day) {
        //如果是倒数第1天,就是1个
        if (day == 1) {
            return 1;
        }
        //如果不是倒数第1天,则与后一天的数量,有函数关系
        else {
            return (todayCount(day - 1) + 1 ) * 2;
        }
    }
}
