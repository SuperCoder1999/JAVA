package chapter13commonclass.stringbuilder;

/*
    一：基本介绍
    1. 也是一个可变的字符序列。此类提供一个与StringBuffer兼容的API，但不保证
    同步（StringBuilder不是线程安全）。该类被设计用于StringBuffer的一个简易替代，用在字符串缓冲区被
    单线程使用的时候。如果可能，简易优先采用该类，应为大多数情况下，比StringBuffer快。
    2. 在StringBuilder上主要操作是append和insert方法，可重载这些方法，以接受任意类型的数据。

    二：StringBuilder的继承
        1. StringBuilder 也继承 AbstractStringBuilder 类
        2. 实现了 Serializable ,说明StringBuilder对象是可以串行化(对象可以网络传输,可以保存到文件)
        3. StringBuilder 是final类, 不能被继承
        4. StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder的 char[] value;
          因此，字符序列是堆中
        5. StringBuilder 的方法，没有做互斥的处理,即没有synchronized 关键字,因此在单线程的情况下使用
          StringBuilder
 */

public class StringBuilderIntroduce01 {
}
