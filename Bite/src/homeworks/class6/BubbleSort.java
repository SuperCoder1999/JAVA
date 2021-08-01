package homeworks.class6;


import java.util.Arrays;

/*
作业标题
冒泡排序

作业内容
给定一个整型数组, 实现冒泡排序(升序排序)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 2, 44, 3, 98, 45, 32, 24 , 6, 10};
        System.out.println("before sort：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after sort: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }
}
