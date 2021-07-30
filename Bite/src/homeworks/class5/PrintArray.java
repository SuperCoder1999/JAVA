package homeworks.class5;
/*
作业标题
打印数组

作业内容
实现一个方法 printArray, 以数组为参数,
循环访问数组中的每个元素, 打印每个元素的值.
 */
public class PrintArray {
    public static void main(String[] args) {
        double[] arr = {1.1, 1.2, 1.3, 1.4, 1.5};
        printArray(arr);
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
