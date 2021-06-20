package chapter10oopsenior.codeblock;

/*
    一：代码块基本介绍
      1. 代码块又称 初始化块，属于类中的成员【即类的一部分】，类似于方法，将逻辑语句
     封装在方法体中，通过{}包围起来。代码块本质是构造器的一种补充
      2. 但和方法不同的时，代码块没有方法名、返回类型、参数。只有方法体，
     且不用通过对象或类显式调用，而是在类加载时【静态代码块】或创建对象时【普通代码块】隐式调用

    二：基本语法
      [修饰符]{
        代码
      }
     注意：
     1. 修饰符是可选项，要写的话，只能写static
     2. 代码块分为两类，使用static修饰的叫静态代码块，没有static修饰的叫普通代码块
     3. 逻辑语句可以为任意逻辑语句（输入、输出、方法调用、循环、判断等）
     4.  ;   可以写，可以省略
     5. 代码块调用的顺序优先于构造器
 */
public class Introduce {
    public static void main(String[] args) {

        Movie movie = new Movie("你好，李焕英");
        System.out.println("===============");
        Movie movie2 = new Movie("唐探3", 100, "陈思诚");
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    //3个构造器-》重载
    //详细解读
    //(1) 下面的三个构造器都有相同的语句
    //(2) 这样代码看起来比较冗余
    //(3) 这时我们可以把相同的语句，放入到一个代码块中，即可
    //(4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
    //(5) 代码块调用的顺序优先于构造器..
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正是开始...");
    }

    public Movie(String name) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        System.out.println("Movie(String name) 被调用...");
        this.name = name;
    }

    public Movie(String name, double price) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正是开始...");
        System.out.println("Movie(String name, double price, String director) 被调用...");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
