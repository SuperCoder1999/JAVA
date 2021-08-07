package homeworks.class8;
/*
作业标题
奇数放到数组后面

作业内容
给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
 */
public class EvenBeforeOdd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int left = 0, right = arr.length - 1;// 下标最大值是长度-1
        System.out.println("调整前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        while (left <= right) {
            while (arr[left] % 2 == 0)
                left++;
            while (arr[right] % 2 != 0)
                right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        System.out.println("\n调整后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
