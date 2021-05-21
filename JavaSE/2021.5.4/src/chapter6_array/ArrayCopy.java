package chapter6_array;

/**
 * //将 int[] arr1 = {10,20,30}; 拷贝到 arr2数组,
 * 		//要求数据空间是独立的.
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {1 , 2 , 3 , 4 , 5};
        int[] arr2;
        arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        arr2[0] = 10;
        System.out.println("---arr1 元素:---");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\n---arr2 元素:---");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
