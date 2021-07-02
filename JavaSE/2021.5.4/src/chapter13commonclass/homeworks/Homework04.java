package chapter13commonclass.homeworks;

/*
    注意：str.charAt(i) 只能将字符取出来而不能修改，
    因为String中的value是final类型，且字符串本体是在常量池的
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "abcHsp U 1234";
        try {
            countStr(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void countStr(String str) {
        if (str == null)
            throw new RuntimeException("数组不能为空");
        int upperCount = 0;
        int lowerCount = 0;
        int numCount = 0;
        int otherCount = 0;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {//也可以使用str.charAt(i)来判断
            if (chars[i] <= 'Z' && chars[i] >= 'A')
                upperCount++;
            else if (chars[i] <= 'z' && chars[i] >= 'a')
                lowerCount++;
            else if (chars[i] <= '9' && chars[i] >= '0')
                numCount++;
            else
                otherCount++;
        }
        /*
                for (int i = 0; i < strLen; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numCount++;
            } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCount++;
            } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }
         */

        System.out.println("数字有 " + numCount);
        System.out.println("小写字母有 " + lowerCount);
        System.out.println("大写字母有 " + upperCount);
        System.out.println("其他字符有 " + otherCount);
    }
}
