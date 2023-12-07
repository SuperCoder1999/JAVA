package chapter4operator.AssignmentOperator;

/**
 * 关于算术运算符细节
 *
 */
public class ContinuousAssignment {
    public static void main(String[] args) {
        continuousAssignment();
    }

    /**
     * 1. 连续赋值，赋值时要从右往左看，int a=b=5; 原理是：b=5，然后将b=5这个赋值语句的结果赋值给a；所以a=b=c+1；也是对的。
     * 而b=a+1＝5，该语句明显错误，原因是将5赋值给a+1
     */
    public static void continuousAssignment() {
        int a, b, c=1;
        a=b=c+1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
