package chapter4operator.AssignmentOperator;

import org.junit.jupiter.api.Test;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/12 3:17
 * Description 赋值运算符 之 复合赋值运算符
 * 1.隐式强制转换
 * 2.先计算右边表达式的值,再执行复合运算,最后赋值
 */
public class CompoundAssignmentOperators {
    /**
     * 隐式强制转换
     */
    @Test
    public void implicitCast() {
        //+=的隐式强制转换(论byte转int,还是int转double,都可以)
        //此处a+=b隐式地将相加操作的计算结果强制转化为持有结果的变量的类型，即a的类型byte
        int m = 1;
        byte n = 2;
        n += m;
        System.out.println(n);//3
        System.out.println(m);//1
    }

    /**
     * 先计算右边表达式的值,再执行复合运算,最后赋值
     */
    @Test
    public void combination() {
        int m = 1;
        int n = 2;
        int res = 0;
        //等价于 res += (m + n)
        res += m + n;
        System.out.println(res);//3
    }
}
