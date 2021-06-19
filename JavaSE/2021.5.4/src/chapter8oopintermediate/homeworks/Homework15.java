package chapter8oopintermediate.homeworks;

/*
一：多态【即多种状态】的基本介绍
    方法或对象具有多种形态，是面向对象的第三大特征。多态是建立在封装和继承基础之上的
二：多态的具体体现
    1）方法的多态
      重写和重载就体现多态
    2）对象的多态（难点）
      a.一个对象的编译类型和运行类型可以不一致
      b.对象名 的编译类型在定义对象时就确定了，不能改变。
        （是否能在强制转换中改变？答案：强制类型转换并没有改变变量本身的类型，而是截取并赋值给另一个变量）
      c.对象名所指向的对象本体，其类型是可以变化的
      d.编译类型的判断看定义时 等号 左边，运行类型看定义时的 等号 右边
      运行类型：可以通过getClass()来查看：obj.getClass()
 */
public class Homework15 {
    public static void main(String[] args) {
        AAA15 obj = new BBB15();//向上转型
        AAA15 b1 = obj;
        System.out.println("obj的运行类型=" + obj.getClass());//BBB
        obj = new CCC15();//向上转型

        System.out.println("obj的运行类型=" + obj.getClass());//CCC
        obj = b1;

        System.out.println("obj的运行类型=" + obj.getClass());//BBB
    }

}

class AAA15 {//超类

}

class BBB15 extends AAA15 {//父类

}

class CCC15 extends BBB15 {//子类

}
