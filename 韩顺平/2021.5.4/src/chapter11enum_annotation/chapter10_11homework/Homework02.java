package chapter11enum_annotation.chapter10_11homework;
/*
1.在Frock类中声明私有的静态属性currentNum[int类型]，初始值为100000，作为衣服出厂的序列号起始值。
2.声明公有的静态方法getNextNum，作为生成上衣唯一序列号的方法。每调用一次，将currentNum增加100，并作为返回值。
3.在TestFrock类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。
4.在Frock类中声明serialNumber(序列号)属性，并提供对应的get方法；
5.在Frock类的构造器中，通过调用getNextNum方法为Frock对象获取唯一序列号，赋给serialNumber属性。
6.在TestFrock类的main方法中，分别创建三个Frock 对象，并打印三个对象的序列号，验证是否为按100递增
 */
public class Homework02 {
    public static void main(String[] args) {
        //Frock f1 = new Frock();
        System.out.println(Frock.getNextNum());

        //Frock f2 = new Frock();
        System.out.println(Frock.getNextNum());

        Frock f3 = new Frock();
        System.out.println(f3.getSerialNumber());

        Frock f4 = new Frock();
        System.out.println(f4.getSerialNumber());

        Frock f5 = new Frock();
        System.out.println(f5.getSerialNumber());
        // 从之前错误的经验来看。可以总结出：构造器和getNextNum两个有实现同一目的。
        //所以构造器和getNextNum只能同时调用一个（所以这就是为什么getNextNum是静态方法）
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNumber;

    public static int getNextNum() {
        return Frock.currentNum += 100;
    }

    public Frock() {
        serialNumber = Frock.getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}