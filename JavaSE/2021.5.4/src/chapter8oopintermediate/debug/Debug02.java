package chapter8oopintermediate.debug;

public class Debug02 {
    public static void main(String[] args) {
        //debug过程中出现异常的情况
        int[] arr = {-1, 10, 0};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("退出for");
    }
}
