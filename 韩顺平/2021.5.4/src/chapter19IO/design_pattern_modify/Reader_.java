package chapter19IO.design_pattern_modify;

public abstract class Reader_ { //抽象类
    public void readFile() {
    }
    public void readString() {
    }
    //public abstract void read(); 就是说将上面两个（在子类中功能不一样的方法 做成一个抽象类，在子类中会单独实现。
    //并且由于动态绑定机制而实现不同功能。

    //在Reader_ 抽象类，使用read方法统一管理.
    //后面在调用时，利于对象动态绑定机制， 绑定到对应的实现子类即可.
    //public abstract void read();
}


