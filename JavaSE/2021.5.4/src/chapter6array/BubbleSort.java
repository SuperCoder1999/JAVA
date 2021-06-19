package chapter6array;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length - 1; i++) {//比较了arr.length-1 轮
            int flag = 1;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 从第一轮找规律，第一轮理 j 从0到arr.length-1 变化
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 0;
                }
            }
            if (flag == 1)
                break;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length - 1; i++) {//比较了arr.length-1 轮
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 从第一轮找规律，第一轮理应 j 从0到arr.length-1 变化
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
*/