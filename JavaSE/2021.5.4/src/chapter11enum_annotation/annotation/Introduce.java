package chapter11enum_annotation.annotation;

/*
    一：注解定义
    1. 注解也成为元数据，用于修饰解释 包、类、方法、属性、构造器、局部变量等数据信息
    2. 和注释一样，注解不影响程序逻辑，但是注解可以被编译或运行，相当于嵌入再代码中的补充信息
    3. 再JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
      在JavaEE中注解占据了重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁荣
      代码和XML配置等

    二：基本注解介绍
     1. 说明：使用注解时要在其前面添加 @ 符号，并把该注解当成一个修饰符使用。用于修饰它支持的
    程序元素
     2. 三个基本的注解
        1）@Override:限定某个方法是重写父类方法，该注解只能用于方法
        2）@Deprecated_：用于表示某个程序元素（类、方法等）已过时
        3）@SuppressWarning:一直编译器警告
 */
public class Introduce {

}
