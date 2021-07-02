package chapter13commonclass.stringbuffer;

/*
    一：简介
    1. java.lang.StringBuffer代表可变的字符序列，可以对字符串内容进行增删
    2. 许多方法与String相同，但是StringBuffer是可变长度的
        【StringBuffer中存储字符串的数组不是final类型】
    3. StringBuffer是一个容器

    二：
        1. StringBuffer 的直接父类 是 AbstractStringBuilder
        2. StringBuffer 实现了 Serializable, 即StringBuffer的对象可以串行化
        3. 在父类中  AbstractStringBuilder 有属性 char[] value,不是final
       该 value 数组存放 字符串内容，引出存放在堆中的
        4. StringBuffer 是一个 final类，不能被继承
        5. 因为StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
       不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String


    三：String 和 StringBuffer 比较
    1. String对象中的value属性保存的是字符串常量地址，其指向的常量池中的地址不能改变。每次String的更新实际上
    都是另外创建String对象来变换value指向的地址。 原因：private final char value[];
    2. StringBuffer对象中的value属性也保存的是字符串地址，区别在于：StringBuffer会在堆中创建所需的字符串，而不是直接指向常量池。
    并且由于value[]不是final类型，所以每次更新内容，可以直接更新value指向的地址，不用重新创建StringBuffer对象。效率更高。
    原因：char value[]; 因为通过以下方式
    StringBuffer hello = new StringBuffer("hello");
    创建时char[] 大小就是 str.length() + 16。所以常量池应该没有保留hello
 */


public class StringBufferIntroduce01 {
}
