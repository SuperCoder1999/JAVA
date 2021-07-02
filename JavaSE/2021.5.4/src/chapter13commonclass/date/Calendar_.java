package chapter13commonclass.date;

import java.util.Calendar;

/*
    第二代日期类
    1. 第二代日期类，主要是Calendar类

    2）Calendar类是一个抽象类，它为特定瞬间提供与一组诸如YEAR、MONTH、DAY_OF_MONTH、HOUR等
    日历字段之间的转换提供了方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法


    1. Calendar是一个抽象类， 并且构造器是private
    2. 可以通过 getInstance() 来获取实例
    3. 提供大量的方法和字段提供给程序员 - 下面代码示例
    4. Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
    5. 如果我们需要按照 24小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
 */

public class Calendar_ {
    public static void main(String[] args) {

        // 2.可以通过 getInstance() 来获取实例
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);

        //3.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
            //这里为什么要 + 1, 因为Calendar 返回月时候，是按照 0 开始编号
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //4.Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

    }
}
