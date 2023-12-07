package chapter8oopintermediate.debug;

import java.util.Arrays;
public class Debug03 {
    public static void main(String[] args) {
        // 如何追源码
        int[] arr = {1, -1, 10, -20, 100};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}
