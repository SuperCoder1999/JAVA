package chapter10oopsenior.main_;

public class MainIntroduce {
    /*
    解释main方法的形式：public static void main(String[] args)
    1. main方法是虚拟机调用
    2. Java虚拟机需要调用类的main()方法，所以该方法的访问权限必须是public
    3. Java虚拟在执行main()方法时不必创建对象，所以该方法必须是static
    4. 该方法接收String类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数
        传参方式: java 执行的程序名 参数1 参数2 参数3 参数4 、、、
    注意：
    1.类方法（静态方法）中 只能 访问静态变量和静态方法 【访问非静态类的成员可以通过创建对象来实现】

     */


    //静态的变量/属性
    private static  String name = "我的";
    //非静态的变量/属性
    private int n1 = 10000;

    //静态方法
    public static  void hi() {
        System.out.println("Main01的 hi方法");
    }
    //非静态方法
    public void cry() {
        System.out.println("Main01的 cry方法");
    }

    public static void main(String[] args) {

        //可以直接使用 name
        //1. 静态方法main 可以访问本类的静态成员
        System.out.println("name=" + name);
        hi();
        //2. 静态方法main 不可以访问本类的非静态成员
        //System_.out.println("n1=" + n1);//错误
        //cry();
        //3. 静态方法main 要访问本类的非静态成员，需要先创建对象 , 再调用即可
        MainIntroduce main01 = new MainIntroduce();
        System.out.println(main01.n1);//ok
        main01.cry();
    }
}
