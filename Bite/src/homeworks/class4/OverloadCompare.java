package homeworks.class4;

public class OverloadCompare {
    public static void main(String[] args) {
        System.out.println("12,13的最大值：" + max(12, 13));
        System.out.println("1.2, 0.4的最大值= " + max(1.2, 0.4));
        System.out.print("1.5, 0.2, 1的大小关系：");
        compare(1.5, 0.2, 1);
    }

    public static int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public static double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    public static void compare(double n1, double n2, int n3) {
        if (n1 > n2) {
            double temp = 0;
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if (n3 < n1)
            System.out.println(n3 + " <" + n1 + " <" + n2);
        else if (n3 < n2)
            System.out.println(n1 + " <" + n3 + " <" + n2);
        else
            System.out.println(n1 + " <" + n2 + " <" + n3);
    }
}
