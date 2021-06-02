package chapter8oopintermediate.poly;

public class PolyIntroduction {
    public static void main(String[] args) {
        /*
        一：多态【即多种状态】的基本介绍
            方法或对象具有多种形态，是面向对象的第三大特征。多态是建立在封装和继承基础之上的
        二：多态的具体体现
            1）方法的多态
              重写和重载就体现多态
            2）对象的多态（难点）
              a.一个对象的编译类型和运行类型可以不一致
              b.对象名 对应的编译类型在定义对象时就确定了，不能改变。
                （是否能在强制转换中改变？答案：强制类型转换并没有改变变量本身的类型，而是截取并赋值给另一个变量）
              c.对象名 对应的运行类型是可以变化的
              d.编译类型的判断看定义时 等号 左边，运行类型看定义时的 等号 右边
         */

        // 对象的多态
        Animal animal = new Dog();
          // animal的编译类型是Animal ，运行类型是 Dog
        animal.cry();
          // 运行时，animal的运行类型是Dog，所以cry是Dog中的cry

        animal = new Cat();
          // animal 编译类型还是Animal，运行类型是Cat
        animal.cry();//这就体现了运行类型的变化。同时对比得出编译类型不可变的事实
    }
}

// 对象多态的例子
class Animal {
    public void cry() {
        System.out.println("动物叫--");
    }
}

class Dog extends Animal {
    public void cry() {
        System.out.println("小狗 汪汪叫");
    }
}

class Cat extends Animal {
    public void cry() {
        System.out.println("小猫 喵喵叫");
    }
}