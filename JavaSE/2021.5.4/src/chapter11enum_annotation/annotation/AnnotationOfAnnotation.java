package chapter11enum_annotation.annotation;

import java.lang.annotation.Inherited;

/*
    一：元注解的基本介绍
    1. JDK的元注解适用于修饰其他注解的

    二：元注解的种类
    1. Retention：指定注解的作用范围，三种：SOURCE,CLASS,RUNTIME
    2. Target：指定注解在哪些地方使用
    3. Documented：指定该注解会不会在javadoc体现
    4. Inherited：子类会不会继承父类注解

    一：@Retention注解
    1. 说明：只能用于修饰一个注解定义，用于指定该注解可以保留多长时间。
     @Retention包含一个RetentionPolicy 类型的成员变量，
     使用@Retention时必须为该成员变量(value)指定值
    2. @Retention的三种值
    1）RetentionPolicy.SOURCE:编译器使用后，直接丢弃这种策略的注释
     只保留在Java源码中
    2）RetentionPolicy.CLASS:编译器把注释记录在class文件中，当运行Java程序时，
     JVM不会保留注解。这是默认值
    3)RetentionPolicy.RUNTIME:编译器将把注解记录在class文件中，
     当运行java程序时，JVM会保留注解。程序可以通过反射获取该注解
    3. 示例：
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE) 的意思就是只保留在源码中
    public @interface Override {
    }

    二：@Target
    1.基本说明
     用于修饰注解定义，指定被修饰的注解能修饰哪些程序元素。
    2. @Target也包含一个value()成员变量
     其中追溯ElementType可以看到这些变量可以取的值
    3. 示例
     @Documented
     @Retention(RetentionPolicy.RUNTIME)
     @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE,
     METHOD, PACKAGE, PARAMETER, TYPE})// 修饰的程序元素
     public @interface Deprecated {
     }

     三：@Documented
     1. 基本说明：
      @Documented是用于指定被该元注解修饰的注解将被javadoc工具提取成文档，
      即在生成文档时，可以看到该注解
     2. 示例
      在jdk文档中许多过时的方法，打开后看到注释：@Deprecated

     四：@Inherited(暂时不会用）
     1.基本说明
      被他修饰的注解将具有继承性。如果某个类使用了被@Inherited修饰的注解，
     则其子类将自动具有该注解
     2.
 */
public class AnnotationOfAnnotation {
}


class AA {

    public void f1(){
        System.out.println("12");
    };
}

class BB extends AA{
    public void f2() {
        System.out.println("123");
    }
}


