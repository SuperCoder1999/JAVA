package chapter6_array;

/**
 *  交换 {11,22,33,44,55,66}
 */
public class ArrayReverse01 {
    public static void main(String[] args) {
        int[] arr = {11 , 22 , 33 , 44 , 55 , 99};
        for (int i = 0; i <= arr.length/2; i++) { //也可以是 left 和 right 比较
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
