package Classroom.class2operator;

/*
    1. % 的结果符号 和 被取模的数 相同
    Java中 可以对小数 取模

    2. 复合运算符 可以自动进行 强制转换

    3. 后置++ 的 难点： a = a++;

    4. && 短路与 和 C语言相同。 & - 逻辑与（一般不推荐）

    5. ！ 取反运算符 或称为 非运算

    6. 位运算：&、|、~、……

    7. 在一个十进制转换为 2进制时，如何判断得到余数是在左还是右：
    第一个余数其实就是 10进制数的奇偶性，所以第一个余数是在最右边。

    8. 只有无符号右移 >>> .没有 <<<  (毕竟 <<< 不看符号)
    9. 三目运算符 也有短路机制
 */

public class Knowledge {
    public static void main(String[] args) {
        // 第一点
        System.out.println(11.5 % 2.0);

        // 2.
        short sh = 10;
        sh += 19;// 相当于 sh = (short) (sh + 19);
        System.out.println(sh);

        // 3.
        int a = 10;
        a = a++;
        /* 其实有两个内存块用于存放这里的两个a。
        可以这么理解：a在运算前 赋值给temp， 之后 a++；temp 赋值给 a。
        */
        System.out.println(a);

        // 9. 三目运算符 也有短路机制
        int b1= 1;
        int b2 = 2;
        int b3 = b1 < b2 ? b1 : b2++;
        System.out.println(b3 + " " + b2);
    }
}