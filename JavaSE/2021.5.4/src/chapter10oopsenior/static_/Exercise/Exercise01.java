package chapter10oopsenior.static_.Exercise;

public class Exercise01 {

}

class Test {
    static int count = 9;

    public void count() {
        System.out.println("count=" + (count++));
    }

    public static void main(String args[]) {
        new Test().count(); //9
        new Test().count(); //10
            //凡是创建Test()的对象，其中的count属性都是共用一个公共变量
        System.out.println(Test.count);    //11
    }
}