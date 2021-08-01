package homeworks.class6;

/*
作业标题
数组是否有序

作业内容
给定一个整型数组, 判定数组是否有序（递增）
 */
public class IsSorted {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("{1, 2, 3, 4, 5, 6}是否递增：" + isSorted(arr1));
        int[] arr2 = new int[]{11, 2, 32, 45, 23, 12};
        System.out.println("{11, 2, 32, 45, 23, 12}是否递增：" + isSorted(arr2));
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}
