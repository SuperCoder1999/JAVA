package homeworks.class4;
/*
作业标题
求最大值

作业内容
创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
 */
public class OverloadMax {
    public static void main(String[] args) {
        System.out.println("10, 9 的最大值=" + max2(10,9));
        System.out.println("11, 10, 12 的最大值= " + max3(11, 10, 12));
    }

    public static int max2(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public static int max3(int n1, int n2, int n3) {
        return n3 > max2(n1, n2) ? n3 : max2(n1, n2);
    }

//    public static int max3(int n1, int n2, int n3) {
//        return n3 > ((n1 > n2) ? n1 : n2) ? n3 : n1 > n2 ? n1 : n2;
//    }
}
