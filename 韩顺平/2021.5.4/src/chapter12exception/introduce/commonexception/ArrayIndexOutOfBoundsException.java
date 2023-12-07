package chapter12exception.introduce.commonexception;

/*
    用非法索引访问数组时抛出的异常。
 */

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}