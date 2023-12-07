package package01;
/**
 * 学习 继承
 */
public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name="聂健";
        pupil.age=22;
        pupil.setScore(100);

        Graduate graduage = new Graduate();
        graduage.name="小沈";
        graduage.age=20;
        graduage.setScore(99);

        pupil.testing();
        graduage.testing();

        pupil.showInfor();
        graduage.showInfor();

        package02.Print p = new package02.Print();
        // 这里创建的是package02包的Print类
        p.print01();
        // 即使package01中没有Print类，也必须附带Print的包的位置
        // 如果设置使用import添加包，Print自动指向package02
    }
}
