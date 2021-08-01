package homeworks.class4;
/*
作业标题
找出出现一次的数字

作业内容
有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
 */
public class ShowOnce {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println("只出现一次的数字是 = " + result);
    }
}
