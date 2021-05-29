package chapter6array;

public class Homework07 {
    public static void main(String[] args) {
       // int[] arr = {4, 6, 2, 1, 0, 56};
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            int key = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    key = 1;
                }
            }
            if (key == 0)
                break;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
