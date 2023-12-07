package chapter7oopprimary.This;

public class ThisIntroduction {
    public static void main(String[] args) {
        // 1.this关键字的作用：在当属性与局部变量冲突的范围内使用全局变量
        // 2.this的本质：在堆区内，开辟的对象空间，不仅分配了name和age空间，还隐藏
            //分配this空间，用于存放该对象空间的地址。（本质的解释可能不准确）

        Dog aDog = new Dog("Tom", 1);
        // 利用hashcode 返回对象地址（那说明this也是对象）
        System.out.println("对象Dog的hashCode" + aDog.hashCode());

        //this是代替创建的对象（对象名不是对象）,哪个对象调用就代替哪个
        System.out.println("-------");
        aDog = new Dog("Jack", 2);
        aDog.info();

    }
}

class Dog {

    String name;
    int age;

//    public Dog(String dName, int dAge) {
//        name = dName;
//        age = dAge;
//    }
    //如果将上面的构造器中的形参改成和属性同名，则出错
    /*public Dog(String name, int age) {
        name = name;
        //引出this：this.name = name;
        age = age;//这里的两个age都是局部变量，所以输出或调用属性时，还是默认值
    }*/
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造器中显式this的hashCode" + this.hashCode());
    }

    public void info() {
        System.out.println("this是代替创建的对象（对象名不是对象）" +
                ",哪个对象调用就代替哪个" + this.hashCode());
    }
}