package examination.day07;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.chkParenthesis("(()())", 6));
    }

    public boolean chkParenthesis(String A, int n) {
        // 1. 优化点: 栈(数组实现)长度为 (n+1)/2 .如果超过这个,说明消不完前面的左括号了
        // 2. 栈(队列),这个数据结构  没有很熟练

        char[] chars = A.toCharArray();
        char[] zhan = new char[(n + 1) / 2];

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (index == 0 && chars[0] == ')') {
                return false;
            }
            if (chars[i] == '(') {
                zhan[index++] = chars[i];
            } else if (chars[i] == ')') {
                if (zhan[index-1] == '(')
                    index--;
                else
                    zhan[index++] = chars[i];
            } else
                zhan[index++] = chars[i];
        }
        if (index == 0)
            return true;
        else
            return false;
        /* 没有看到,这里不是 手动处理字符串
        //1. 这里的 数字 给的时候是在 字符串后面. 用栈进行验证,那么这个数字就没作用了
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String split = "\",";
        String[] strs = str.split(split);
        String judge = strs[0].substring(1);
        System.out.println(judge);
        char[] chars = judge.toCharArray();

        char[] zhan = new char[(Integer.parseInt(strs[1]) + 1) / 2];

        int index = 0;
        for (int i = 0; i < Integer.parseInt(strs[1]); i++) {
            if (index == 0 && chars[0] == ')') {
               return false;
            }
            if (chars[i] == '(') {
                zhan[index++] = chars[i];
            }
            if (chars[i] == ')') {
                index--;
            }
            else
                index ++;
        }
        if (index == 0)
            return true;
        else
            return false;*/
    }
}
