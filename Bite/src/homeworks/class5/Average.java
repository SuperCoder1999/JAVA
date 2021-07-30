package homeworks.class5;

/*
    作业标题
    求数组的平均值

    作业内容
    实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型)
 */

public class Average {
    public static void main(String[] args) {
        /*
            创建数组有两种方式：1. new int[10] 此时需要for进行赋值
            2. 直接进行初始化 int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
         */
        int[] arr = new int[10];
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("average = " + average(arr1));
    }

    public static double average(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}
