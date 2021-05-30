package chapter8oopintermediate.idea;

public class CreateProject {
    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 67, -10, 98};
        MyTools aMyTools = new MyTools();
        aMyTools.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class MyTools {
    // 冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 1;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = -1;
                }
            }
            if (flag == 1)
                return;
        }
    }
}