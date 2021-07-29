package Classroom.class1datatype;

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
    5. char  在Java中是两个字节 - 字符对应的数值 是 Unicode表
     大小是 0 - 2^16-1

     6. 显示赋值的时候，idea会检验范围。而加减运算不会检验范围。

     7. boolean 的大小 有些书说是 1bit （Java没有规定其大小）

     8. 数据类型分为：1. 基本/内置/简单类型  2. 引用类型

     9. 字符串和任意数据类型 + 得到的都是字符串。
        字符串在前面一定是字符串
        如果是 1 + 2 + "123“ 得到的是 3123。前面的 + 算作是 运算符
     10. Java中的常量是用
        final修饰函数的方法叫：密封方法  修饰类：密封类
     11. 字面值常量
        10 // int 字面值常量（十进制）
        010 // int 字面值常量（八进制） 由数字 0 开头 010 - 8（十进制）
        0x10 // int 字面值常量（16进制） 由数字0x开头，0x10 - 16（十进制）
        10L // long 字面值常量，也可以写作 10l（小写的L）
        1.0 // double 1.0d/1.0D
        1.0f // float 1.0F/1.0f
        1.5e2 // 1.5*10^2
    12. byte 、 short、char 在计算时，会自动转换成int类型
    byte b = 10 + 20; 是可通过的

    13. 一个操作：Terminal - ：cd src -> javac -encoding utf-8 HelloWorld.java
    生成 字节码文件.class   -> javap -c HelloWorld 反汇编（老师说没必要学？）

    14. 在多种类型数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后进行计算

    15. str.valueOf(int a);可以将int转变为 String
    //String -> 基本数据类型
        int num1 = Integer.parseInt(s5); - 叫做 装包
        double num2 = Double.parseDouble(s5);
        float num3 = Float.parseFloat(s5);
        long num4 = Long.parseLong(s5);
        byte num5 = Byte.parseByte(s5);
        short num6 = Short.parseShort(s5);
        boolean num7 = Boolean.parseBoolean("true");


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

        // 第5点，查看 char 的范围
        System.out.println((int)Character.MAX_VALUE);

        //byte b = 128;// 第6点的体现

        String str = "1223" + 123;// 第9点

        byte b1 = 12;
        byte b2 = 10;
        //byte = b1 + 1; 第12点


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
