package chapter11enum_annotation.enum_.keywordenum;

/*
    二：使用enum关键字来实现枚举
    1. enum枚举的实现步骤
        1）使用关键字 enum 替代 class
        2）public static final Season SPRING = new Season("春天", "温暖") 直接使用
            SPRING("春天", "温暖") 即 常量名(实参列表)  来代替
        3) 如果有多个常量(对象)， 使用 ,号间隔即可
        4) 如果使用enum 来实现枚举，要求将定义的常量对象，写在前面
        5) 如果我们使用的是无参构造器，创建常量对象，则可以省略 ()
            注意：enum中的要素和普通类的一样，即一旦自定义了构造器，无参构造器就会被覆盖

    2. enum关键字实现枚举的细节
        1）当使用enum关键字定义一个枚举类时，默认会继承Enum类（java p来查看反编译代码）
            从反编译代码中可以看出，enum定义出的本质还是一个final的类
        2）如果使用enum 来实现枚举，要求将定义的常量对象，写在前面
        3）enum本质是一个final类，且已经继承了Enum类。所以不能再继承其他类。但是可以
            实现其他接口
            形式：
            enum 类名 implements 接口1，接口2 {}
    3. 枚举常量的调用：
        类名.枚举常量名


        反汇编代码
        Compiled from "KeywordEnumIntroduce.java"
    final class chapter11enum_annotation.enum_.keywordenum.Season2 extends java.lang.Enum<chapter11enum_annotation.enum_.keywordenum.Season2> {
    public static final chapter11enum_annotation.enum_.keywordenum.Season2 SPRING;
    public static final chapter11enum_annotation.enum_.keywordenum.Season2 WINTER;
    public static final chapter11enum_annotation.enum_.keywordenum.Season2 AUTUMN;
    public static final chapter11enum_annotation.enum_.keywordenum.Season2 SUMMER;
    public static chapter11enum_annotation.enum_.keywordenum.Season2[] values();
    public static chapter11enum_annotation.enum_.keywordenum.Season2 valueOf(java.lang.String);
    public java.lang.String getName();
    public java.lang.String getDesc();
    public java.lang.String toString();
    static {};
}
 */
public class KeywordEnumIntroduce {

    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);

        //调用enum类实现接口的方法
        Tiger.TIGER.say();
    }
}

//演示使用enum关键字来实现枚举类
enum Season2 {//类


    //定义了四个对象, 固定.
//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season SUMMER = new Season("夏天", "炎热");
    //如果使用了enum 来实现枚举类
    //1. 使用关键字 enum 替代 class
    //2. public static final Season SPRING = new Season("春天", "温暖") 直接使用
    //   SPRING("春天", "温暖") 解读 常量名(实参列表)
    //3. 如果有多个常量(对象)， 使用 ,号间隔即可
    //4. 如果使用enum 来实现枚举，要求将定义常量对象，写在前面
    //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略 ()
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"),
    SUMMER("夏天", "炎热")/*, What()*/;

    private String name;
    private String desc;//描述

    private Season2() {//无参构造器

    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

interface Animal {
    public void say();
}

enum Tiger implements Animal {
    TIGER;
    public void say() {
        System.out.println("老虎叫");
    }
}