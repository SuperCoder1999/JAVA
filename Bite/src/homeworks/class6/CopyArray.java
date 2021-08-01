package homeworks.class6;

import java.util.Arrays;
/*
作业标题
数组的拷贝

作业内容
实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组
 */
public class CopyArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("before copy: " + Arrays.toString(arr));
        int[] newArr = copyOf(arr);
        System.out.println("after copy: " + Arrays.toString(newArr));
    }

    public static int[] copyOf(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
