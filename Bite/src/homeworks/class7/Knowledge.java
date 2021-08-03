package homeworks.class7;

/*
    1. 第四题：static不能修饰局部变量

    2. 第9题：不太懂
    以下哪项不属于java类加载过程？

    A.生成java.lang.Class对象
    B.int类型对象成员变量赋予默认值
    C.执行static块代码
    D.类方法解析
 */

public class Knowledge {
    public static void main(String args[]){
        Test4.test();

        Test7 test7 = new Test7();
        //test7.x++; 报错
        //Test7.x++; 报错
    }
}

/*
    验证 static是否能修饰局部变量
 */
class Test4 {
    public int aMethod(){
        //static int i = 0;
        int i = 0;
        i++;
        return i;
    }
    public static void test(){
        Test4 test4 = new Test4();
        test4.aMethod();
        int j = test4.aMethod();
        System.out.println(j);
    }
}

/*
    验证 private 在static类变量上是否也是一样的访问权限
    ---类变量也遵循访问权限。
 */
class Test7 {
    private static int x = 100;
    public static void test() {
        Test7 test7 = new Test7();
        test7.x++;//private在同一个类中可以使用
    }
}

/*
    验证 在一个类的构造器中调用其他构造器的格式
    ---只能使用this() 来调用。
 */
class Test8 {
    public Test8() {

    }

    public Test8(int a) {
        //Test8();
        this();
    }
}