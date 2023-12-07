package chapter13commonclass.homeworks;
/*
    技巧：if中先写正确的情况，再取反，这样思路清晰
 */

/*
  (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
  (2) 编写方法 public static String reverse(String  str, int start , int end) 搞定
  思路分析
  (1) 先把方法定义确定
  (2) 把 String 转成 char[] ，因为char[] 的元素是可以交换的
  (3) 画出分析示意图
  (4) 代码实现
 */
public class Homework01 {
    public static void main(String[] args) {
        String s = "abcdef";
        try {
            String newS = reverse(s, 1, s.length() - 1);
            System.out.println(newS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {

        //(1) 写出正确的情况
        //(2) 然后取反即可
        //(3) 这样写，你的思路就不乱
        if (!(str != null && start >= 0 && end >= 0 && start <= end))
            throw new RuntimeException("参数不正确");
        char[] n = str.toCharArray();
        while (start <= end) {
            char temp = n[start];
            n[start++] = n[end];
            n[end--] = temp;
        }
        return new String(n);
    }
}
