package chapter10oopsenior.static_.staticmethod;

/*
    类方法的使用场景
    1.当方法中没有涉及任何和对象有关的成员，则可以将方法设计成静态方法，提高开发效率
     比如：工具类的方法 utils 、Math类 、 Arrays类、 Collections集合类源码中的
    2. 实际开发中，将一些通用的方法设计成静态方法，这样就不要创建对象直接使用了。
        比如打印一维数组、冒泡排序、某个计算任务
 */

public class Case {
    public static void main(String[] args) {
        System.out.println(MyTools.calSum(10, 30));

    }
}

//开发自己的工具类时，可以将方法做成静态的，方便调用
class MyTools  {
    //求出两个数的和
    public static double calSum(double n1, double n2) {
        return  n1 + n2;
    }
    //可以写出很多这样的工具方法...

}
