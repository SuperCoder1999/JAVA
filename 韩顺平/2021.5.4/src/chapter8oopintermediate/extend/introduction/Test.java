package chapter8oopintermediate.extend.introduction;

public class Test {
    public static void main(String[] args) {
        IntroPupil pupil = new IntroPupil();
        pupil.name = "smith";
        pupil.age = 7;
        pupil.setScore(90);
        pupil.testing();
        pupil.showInfo();

        System.out.println("==============");
        IntroGraduate graduate = new IntroGraduate();
        graduate.name = "Jack";
        graduate.age = 21;
        graduate.setScore(99);
        graduate.testing();
        graduate.showInfo();
    }
}
