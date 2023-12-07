package WinterHomeworks2022.CAndJava.Program.Day04;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/9 15:38
 * Description 递归 => 已知起始信息,且知道后续值和起始信息的关系
 * 1.题目: 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三
 * 个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多
 * 大？
 */
public class Solution01 {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(getAge(number));
    }

    public static int getAge(int number) {
        if (number == 1) {
            return 10;
        }
        else {
            return getAge(number - 1) + 2;
        }
    }
}
