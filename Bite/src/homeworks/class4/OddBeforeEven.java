package homeworks.class4;
/*
作业标题
奇数位于偶数之前

作业内容
调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
 */
public class OddBeforeEven {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int left = 0, right = arr.length - 1;// 下标最大值是长度-1
        System.out.println("调整前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        while (left <= right) {
            while (arr[left] % 2 != 0)
                left++;
            while (arr[right] % 2 == 0)
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
