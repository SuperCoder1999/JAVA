package homeworks.class5;
/*
作业标题
创建的数组，并且赋初始值

作业内容
创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
 */
public class Initialize {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("arr ： ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
            if (i % 10 == 0 && i != 0)
                System.out.println();
        }
    }
}
