package chapter10oopsenior.codeblock.Exercise;

public class Exercise01 {

}

class Person {
    public static int total;//静态变量
    static {//静态代码块
        total = 100;
        System.out.println("in static block!");//(1)
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("total = "+ Person.total); //100
        System.out.println("total = "+ Person.total); //100
            // 静态代码块只会调用一次，所以第二次不会显示 in static block!
    }
}
