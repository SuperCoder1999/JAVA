package WinterHomeworks2021.day01.choices;

public class Test1 {
    public static void main(String[] args) {
        String s1 = "hello\n,123";
        System.out.println(s1);

        //java中  \0 不是字符串结束符
        String s2 = "hello\0,123";
        System.out.println(s2);

        char s = '\u0639';
        System.out.println(s);

    }
}
