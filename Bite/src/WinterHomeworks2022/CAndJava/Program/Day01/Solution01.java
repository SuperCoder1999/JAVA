package WinterHomeworks2022.CAndJava.Program.Day01;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 14:05
 * Description 普通小算法 => 大写转小写 => 注意边界值 => 'a'-'A'获取转换的差值
 * 1.题目: 编写程序，输入一个字符，判断它是否为小写字母，如果是，将它转换成大写字母，否则，不转换。
 */
public class Solution01 {
    public static void main(String[] args) {
        System.out.println(lowerCaseToUpper('a'));
        System.out.println(lowerCaseToUpper('z'));
        System.out.println(lowerCaseToUpper('n'));
        System.out.println(lowerCaseToUpper('A'));
        System.out.println(lowerCaseToUpper('Z'));
        System.out.println(lowerCaseToUpper('G'));
    }

    public static char lowerCaseToUpper(char ch) {
        int gap = 'a' - 'A';
        //注意包含边界
        if (ch >= 'a' & ch <= 'z') {
            //
            ch -= gap;
        }
        return ch;
    }
}
