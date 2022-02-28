package examination.day08;
//1. 字符串长度用 循环进行比较. 字符串字典序列用 String的比较方法进行比较
import java.util.Scanner;
public class Solution1 {

        public static void main(String[] args) {
            boolean lex = true;
            boolean lengths = true;
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String[] strs = new String[100];
            for (int i = 0; i < n; i++) {
                //strs[i] = in.nextLine();//这里用 nextLine 第一个字符串读取是 空的
                strs[i] = in.next();
            }
            for (int i = 0; i < n - 1; i++) {
                if (strs[i].length() >= strs[i+1].length()) {
                    lengths = false;
                }
                if (strs[i].compareTo(strs[i + 1]) > 0) {
                    lex = false;
                }
            }
            String res = "none";
            if (lengths && lex)
                res = "both";
            else if (lengths)
                    res = "lengths";
            else if (lex)
                res = "lexicographically";
            System.out.println(res);
    }
}
