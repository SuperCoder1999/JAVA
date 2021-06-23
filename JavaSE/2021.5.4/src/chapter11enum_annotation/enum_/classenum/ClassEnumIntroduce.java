package chapter11enum_annotation.enum_.classenum;
/*
    一：枚举介绍
      枚举是一组常量的集合（枚举属于一种特殊的类，里面只包含一组有限的特定的对象）
    二：枚举的两种实现方式
      1. 自定义类 来实现枚举
      2. 使用enum关键字来实现枚举

    三：自定义类 实现枚举的使用
      1. 创建过程
        1. 将构造器私有化,目的防止 直接 new
        2. 去掉setXxx方法, 防止属性被修改
        3. 在Season 内部，直接创建固定的对象
        4. 优化，可以加入 final(static加上final形成常量属性，调用时就不会被加载)
            static(为了不创建对象直接访问)修饰符

    四：自定义类 实现枚举的注意
        1. 创建的对象最好是public，为了其他类可以直接调用
        2. 对枚举对象/属性使用final+static共同修饰，实现底层优化
        3. 枚举对象名通常全部大写，按照常量的命名规范

 */
public class ClassEnumIntroduce {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
    }
}

//演示字定义枚举实现
class Season {//类
    private String name;
    private String desc;//描述

    //定义了四个对象, 固定.
    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season WINTER = new Season("冬天", "寒冷");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season SUMMER = new Season("夏天", "炎热");


    //1. 将构造器私有化,目的防止 直接 new
    //2. 去掉setXxx方法, 防止属性被修改
    //3. 在Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符
    private Season(String name, String desc) {
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