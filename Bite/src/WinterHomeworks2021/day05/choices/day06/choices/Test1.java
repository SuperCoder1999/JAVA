package WinterHomeworks2021.day05.choices.day06.choices;

public class Test1 {
    public static void main(String[] args) {
        Test1 inc = new Test1();
        int i = 0;
        inc.fermin(i);
        i = i++;
        System.out.println(i);  // 0
    }

    void fermin(int i) {
        i++;
    }
}
