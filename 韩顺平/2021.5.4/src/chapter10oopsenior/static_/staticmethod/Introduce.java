package chapter10oopsenior.static_.staticmethod;

/*
    一：类方法：
      类方法又叫静态方法
    二：形式如下
    访问修饰符 static 数据返回类型 方法名() {} 【推荐】
    static 访问修饰符 数据返回类型 方法名() {}

    三：类方法的调用【同样需要满足访问修饰符的权限】
      类名.类方法名
      对象名.类方法名


 */
public class Introduce {

    public static void main(String[] args) {
        //创建2个学生对象，叫学费
        Stu tom = new Stu("tom");
        //tom.payFee(100);
        Stu.payFee(100);//对不对?对

        Stu mary = new Stu("mary");
        //mary.payFee(200);
        Stu.payFee(200);//对


        //输出当前收到的总学费
        Stu.showFee();//300

        //如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
        //这时，把方法做成静态方法时非常合适
        System.out.println("9开平方的结果是=" + Math.sqrt(9));



    }
}



class Stu {
    private String name;//普通成员
    //定义一个静态变量，来累积学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    //说明
    //1. 当方法使用了static修饰后，该方法就是静态方法
    //2. 静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;//累积到
        // 静态变量在同类中的static方法中调用不能有this\super 如果需要和局部变量区别开来：
        //          类名.类变量名 的方式
    }

    public static void showFee() {
        System.out.println("总学费有:" + Stu.fee);
    }
}