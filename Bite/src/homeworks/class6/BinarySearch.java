package homeworks.class6;

/*
作业标题
二分查找

作业内容
给定一个有序整型数组, 实现二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("{1, 2, 3, 4, 5, 6}中 9 所在的下标：" + binarySearch(arr, 9));
        System.out.println("{1, 2, 3, 4, 5, 6}中 1 所在的下标：" + binarySearch(arr, 1));
        System.out.println("{1, 2, 3, 4, 5, 6}中 6 所在的下标：" + binarySearch(arr, 6));
        System.out.println("{1, 2, 3, 4, 5, 6}中 4 所在的下标：" + binarySearch(arr, 4));

    }

    public static int binarySearch(int[] arr, int x) {
        int index = 0;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x < arr[mid])
                right = mid - 1;// right、left必须在mid基础上变化，否则mid可能一直是同一个值
            else if (x > arr[mid])
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
