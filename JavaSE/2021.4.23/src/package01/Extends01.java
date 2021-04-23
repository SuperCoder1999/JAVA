package package01;

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

        package02.print p = new package02.print();
        // 这里创建的是package02的包
        p.print01();
        // 即使package01中没有print类，也必须附带print的包的位置
        // 如果设置自动添加包，print自动指向package02
    }
}
