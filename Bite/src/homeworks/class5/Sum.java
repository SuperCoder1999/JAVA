package homeworks.class5;
/*
    作业标题
    数组所有元素之和

    作业内容
    实现一个方法 sum, 以数组为参数, 求数组所有元素之和
 */
public class Sum {
    public static void main(String[] args) {
        double[] arr = {1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0};
        System.out.println("sum = " + sum(arr));
    }

    public static double sum(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
