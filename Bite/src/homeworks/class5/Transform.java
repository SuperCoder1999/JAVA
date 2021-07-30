package homeworks.class5;
/*
作业标题
改变原有数组元素的值

作业内容
实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2,并
设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
 */
public class Transform {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5};
        System.out.println("原数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        transform(arr);
        System.out.println("\nafter transform ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //System.out.println(arr);输出的 [I@1b6d3586 可能是地址
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
