package package01;
/**
 * 学习 包
 */
public class Extends01 {
    public static void main(String[] args) {

        // 这里创建的是package02包的Print类
        package02.Print p = new package02.Print();
        p.print01();
        // 即使package01中没有Print类，也必须附带Print的包的位置
        // 如果设置使用import添加包，Print自动指向package02
    }
}
