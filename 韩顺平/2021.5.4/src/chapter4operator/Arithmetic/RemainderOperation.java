package chapter4operator.Arithmetic;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/16 16:16
 * Description 对于取模运算的细节
 * 1.取模运算的本质算法: a%b = a - a/b*b
 * 2.java的取模运算支持类型:字符型(自然不包括负数)、字节型、短整型、整型、长整型、单精度浮点型、双精度浮点型。
 */
public class RemainderOperation {
    public static void main(String[] args) {
        System.out.println(10 % 3.5);
        System.out.println(10 % 3.3);
    }
}
