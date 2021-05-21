package chapter6_array;

/**
 * 请求出一个数组int[]的最大值 {4,-1,9, 10,23}，并得到对应的下标
 */
public class ArrayExercise02 {
    public static void main(String[] args) {
        int[] arr = {4, -1, 8, 9, 100, -1};
        int maxIndex = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        System.out.println(max + " " + maxIndex);
    }
}
