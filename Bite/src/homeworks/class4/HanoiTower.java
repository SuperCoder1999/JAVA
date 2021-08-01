package homeworks.class4;
/*
作业标题
递归求解汉诺塔问题

作业内容
递归求解汉诺塔问题
 */
public class HanoiTower {
    public static void main(String[] args) {
        int n = 3;
        char a = 'A';
        char b = 'B';
        char c = 'C';
        System.out.println("三层汉诺塔步骤：");
        Hanoi(3, a, b, c);
    }

    public static void Hanoi(int n, char a, char b, char c) {
        if (n <= 1)
            System.out.println(a + "->" + c);
        else {
            Hanoi(n-1, a, c, b);//借助c移到b
            System.out.println(a + "->" + c);
            Hanoi(n-1, b, a, c);//借助a移到c
        }
    }
}
