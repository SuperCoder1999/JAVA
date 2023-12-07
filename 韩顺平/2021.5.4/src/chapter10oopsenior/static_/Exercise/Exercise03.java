package chapter10oopsenior.static_.Exercise;

public class Exercise03 {
}
class Person02 { //StaticExercise03.java 2min 看
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total){
        // this.total = total;//错误，因为在static方法中，不可以使用this 关键字

        Person02.total = total;// 可以用这种方式指定赋值对象
    }
    public Person02() {//构造器
        total++;
        id = total;
    }
    //编写一个方法，输出total的值
    public static void m() {
        System.out.println("total的值=" + total);
    }
}
class TestPerson02 {
    public static void main(String[] args) {

        Person02.setTotalPerson(3);
        new Person02(); //最后 total的值就是4
        Person02.m();//看看输出的是不是4
    }
}