package chapter13commonclass.string;

/*
    一：两种创建String对象的区别
    方法一：直接赋值String s = "hello";
    方法二：调用构造器 如：String s2 = new String("hello");

    二：两种方式讲解：
    1. 方式一：先从常量池查看是否有“hello”数据空间。如果有，直接指向；如果没有则创建，
    然后指向。对象名s最终指向的是常量池的空间地址。
    2. 方式二：先在堆中创建空间，里面维护了value属性，value指向常量池的"hello“空间。如果常量池
    没有"hello"，重新创建，如果有，直接通过value指向。对象名s2最终指向的是堆中的new出来的String对象实例的空间地址。
 */
public class CreateString {

}
