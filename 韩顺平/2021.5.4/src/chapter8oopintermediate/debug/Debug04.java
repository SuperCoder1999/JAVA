package chapter8oopintermediate.debug;

import java.util.Arrays;

/*
    如何执行到下一个断点F9 resume
    断点可以在debug过程中动态的下断点
    同样可以在源码中下断点
 */
public class Debug04 {
    public static void main(String[] args) {

        int[] arr = {1, -1, 10, -20 , 100};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
        System.out.println("hello400");
        System.out.println("hello500");
        System.out.println("hello600");
        System.out.println("hello700");
    }
}
