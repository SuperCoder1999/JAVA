package homeworks.class6;

import java.util.Arrays;
/*
作业标题
数组转字符串

作业内容
实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} ,
返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
 */
public class myToString {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = null;
        int[] arr3 = new int[]{};
        System.out.println("原数组：" + Arrays.toString(arr1));
        System.out.println("after toString: " + myToString(arr1));
        System.out.println("原数组：" + Arrays.toString(arr2));
        System.out.println("after toString: " + myToString(arr2));
        System.out.println("原数组：" + Arrays.toString(arr3));
        System.out.println("after toString: " + myToString(arr3));
    }

    public static String myToString(int[] arr) {
        if (arr == null || arr.length == 0)//提高代码健壮性
            return null;
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                str += arr[i] + ", ";
            else
                str += arr[i] +"]";
        }
        return str;
    }
}
