package chapter13commonclass.bignumber;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        //当我们需要保存一个精度很高的数时，double 不够用
        //可以是 BigDecimal
        //double d = 1999.11111111111999999999999977788d;
        //System.out.println(d);
        BigDecimal bigDecimal1 = new BigDecimal("1999.11");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal1);

        //解读
        //1. 如果对 BigDecimal进行运算，比如加减乘除，必须使用对应的方法
        //2. 也可以创建一个 BigDecimal 存放结果
        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        System.out.println(bigDecimal1.multiply(bigDecimal2));
        //System.out.println(bigDecimal.divide(bigDecimal2));
        // 可能抛出异常ArithmeticException，原因是结果可能是无线循环小数
        //在调用divide 方法时，指定精度即可. BigDecimal.ROUND_CEILING
        //如果结果是无限循环小数，就会保留 和分子同样 的精度
        System.out.println(bigDecimal1.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
    }
}
