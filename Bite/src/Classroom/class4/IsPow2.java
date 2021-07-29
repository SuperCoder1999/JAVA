package Classroom.class4;

/*
    判断一个数字是否是 2 的 n 次方
 */

public class IsPow2 {
    public static void main(String[] args) {
        System.out.println(isPow2(12));
        System.out.println(isPow2(16));
        System.out.println(isPow2(5));
    }
    public static boolean isPow2(int num) {
        if ((num & (num - 1)) == 0)
        /*
            这里运用二进制的关系 来 判断是否是 2 的次方
            原理：2的次方有特点，即二进制表示法中只有 1 个 1。
            因此，当 - 1 后原本 1后面的0 全变成了 1。此时进行 &。只能得到 0
         */
            return true;
        return false;
    }
}