package Classroom.class1;

/*
    一、知识点：
    1. JDK：Java Development Kit
       JRE：Java Runtime Environment
       JVM：Java Visual Machine
      之间的关系：JDK = JRE + Java开发工具
                JRE = JVM + JavaSE标准类库
    2. Javac 编译平台默认使用GBK编码格式
    使用代码：Javac -encoding utf-8 HelloWorld.java可以修改编译编码格式

    3. Java是强类型语言，等号左右类型不匹配，就会报错（自动转型、强制转型除外）

    4. Java中的自动转换链：int - long - float - double
                         char - int
                         byte - short - int
          注意：char 不能和 byte 自动转换
 */

public class Knowledge {
    public static void main(String[] args) {
        // int 的最大值和最小值 ：-2^31 ~ 2^31-1 (有一个符号位)
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // int 溢出
        /*
            溢出情况可以用 圆形来 考虑
            -1|0
              |
              |
              |
       -2^31  | 2^31-1
                        加 - 顺时针
                        减 - 逆时针
         */
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE - 1);

        // 判断负数的取余后 的结果
        System.out.println(-99 % 10);

        Solution solution = new Solution();
        solution.reverse(1463847412); // 最高位只能以1开头
        solution.reverse(-1463847412); // 最高位只能以1开头

    }
}

class Solution {
    public int reverse(int x) {
        long rev = 0; // 不能用long 存储。最后强制类型
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return (int)rev;
    }
}
