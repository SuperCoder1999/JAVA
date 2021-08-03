package Classroom.class7complexity;

/*
    复杂度；
    1. 复杂度的规模都是n为基数。
    2. 递归的时间复杂度和空间复杂度，需要注意。
    每次递归算 1 个时间复杂度，每次 return 时 都需要一个等待的变量

    3. 斐波那契数列数列的 空间复杂度等于 树高。时间复杂度 等于节点个数
 */

public class Knowledge {
    public static void main(String[] args) {

    }

    // n! 空间复杂度是 O(n)
    // 每一次创建的方法中return的结果 都用一个变量保存，用以等待接收 返回的数据
    public int factorial(int n) {
        return n < 2 ? 1 : n * factorial(n -1);
    }

    // fibonacci 空间复杂度是 O(n)
    // 只需要最左边树节点即可。因为每个节点的左边用完之后就会消掉，并开辟
    // 右边的空间，这样空间大小没有变化。总共使用了 n 个
    public int fibonacci(int n) {
        return n < 2 ? n : fibonacci(n -1) + fibonacci(n - 2);
    }

}
