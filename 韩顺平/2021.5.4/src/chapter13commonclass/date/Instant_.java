package chapter13commonclass.date;

import java.time.Instant;
import java.util.Date;
/*
    四：Instant时间戳
    类似于第一代日期类Date

    提供了一系列和Date类转换的方式
    1）Instant->Date
        Date date = Date.from(now);

    2)Date->Instant
        Instant instant = date.toInstant();
 */

public class Instant_ {
    public static void main(String[] args) {

        //1.通过 静态方法 now() 获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //2. 通过 from 可以把 Instant转成 Date
        Date date = Date.from(now);
        System.out.println(date);
        //3. 通过 date的toInstant() 可以把 date 转成Instant对象
        Instant instant = date.toInstant();
        System.out.println(instant);

    }
}
