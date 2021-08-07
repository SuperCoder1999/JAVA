package homeworks.class8;

//static类变量及类方法在类加载时就加载了。且按照顺序来加载 ---------- 知识点需要巩固
public class Test1{
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args){
        System.out.println("cnt =" + cnt);// 5
    }
    static{
        cnt /=3;
    };
}