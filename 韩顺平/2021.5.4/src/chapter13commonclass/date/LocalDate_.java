package chapter13commonclass.date;

/*
    一：前两代日期类的不足：
    1. JDK 1.0中包含了java.util.Date类，但它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用了。
    而Calendar也存在问题：
        1）可变性：像日期实践这样的类应该是不可变的
        2）偏移性：Date中的年份是从1900开始的，而月份是从0开始的，月份引用起来不方便
        3）格式化：格式化只对Date有用，Calendar则不行
        4）此外，它们也不是线程安全的；不能处理闰秒等（每隔两天，多出1s）
    二：第三代日期类常见方法 （JDK8加入的）
    1. LocalDate（日期/年月日）、LocalTime（时间/时分秒）、LocalDateTime（日期时间/年月日时分秒）

    2.
        1）LocalDate只包含日期，可以获取日期字段
        2）LocalTime只包含时间，可以获得时间字段
        3）LocalDateTime包含日期+时间，可以获取日期和时间字段

    3. 判断是否是闰年 的方法
    4. 提供 plus 和 minus方法可以对当前时间进行加或者减
        使用plus方法测试增加时间的某个部分
        使用minus方法测试减少时间的某个部分

    四：
        第三代日期类中的MonthDay类：检查重复事件
 */

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期

        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);

        //2. 使用DateTimeFormatter 对象来进行格式化 对应字符可以在API文档中查询DateTimeFormatter看到
        // 创建 DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);

        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒


        //提供 plus 和 minus方法可以对当前时间进行加或者减
        //看看890天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前 日期=" + dateTimeFormatter.format(localDateTime2));

    }
}