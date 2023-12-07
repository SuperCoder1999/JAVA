package WinterHomeworks2022.CAndJava.Program.Day01;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 14:49
 * Description 小算法 => 某日期为此年第几天 => 闰年判断:被4整除且不被100整除 || 被400整除
 * 1.题目: 编写程序，对输入的年、月、日，给出该天是该年的第多少天？
 */
public class Solution02 {

    public static void main(String[] args) {
        System.out.println(theDaysInYear(2022, 1, 15));//15
        System.out.println(theDaysInYear(2022, 12, 31));//365

    }
    public static int theDaysInYear(int year, int month, int day) {
        int count = 0;
        //维护每月天数数组
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //判断是否为闰年,更改二月天数
        if (year % 4 == 0 & year % 100 != 0 || year % 400 ==0) {
            months[1] = 29;
        }
        //根据输入月份,将过去的月份天数累计
        for (int i = 0; i < month - 1; i++) {
            count += months[i];
        }
        //累计当月天数
        count += day;

        return count;
    }
}
