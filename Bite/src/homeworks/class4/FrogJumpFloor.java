package homeworks.class4;


public class FrogJumpFloor {
    public static void main(String[] args) {
        System.out.println("跳上 1 级台阶，也可以跳上2 级。9层台阶:"
                + frogJumpFloor1(9));

        System.out.println("可以跳上1级台阶，也可以跳上2 级……它也可以跳上n 级，3层台阶："
                + frogJumpFloor2(3));
    }

    /*
    一、一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。
    求该青蛙跳上一个n 级的台阶总共有多少种跳法。

    解析：n = 1: 1
        n = 2 : 2
        n = 3 : 第一次跳 1 阶，剩余两阶 和 n = 2 情况相同；
        第一次跳 2 个 剩余 1 个台阶，和 n = 2 情况相同
        以此类推
     */
    public static int frogJumpFloor1(int n) {
        int n0 = 1, n1 = 1;
        int result = 1;
        if (n <= 1)
            return result;
        for (int i = 2; i <= n; i++) {
            result = n0 + n1;
            n0 = n1;
            n1 = result;
        }
        return result;
    }

    /*一只青蛙一次可以跳上1级台阶，也可以跳上2 级……它也可以跳上n 级，
     此时该青蛙跳上一个n级的台阶总共有多少种跳法？
    解析：
    n = 1 : 1
    n = 2 : 2
    n = 3 : ①第一次跳一个，剩余两个 和 n=2 情况相同。②第一次跳两个，剩余1个，和 n=1 情况相同
    ③跳三个，只有一种情况。
    所以规律如下：f(n) = f(n-1)+f(n-2)+f(n-3)+f(n-4)...+f(n-n);
    如果按照这个进行递归、或者迭代来算，很麻烦
    （迭代时需要定义n个变量来存f(n-1)...f(n-n)；递归的复杂度过大）

    又f(n-1)=f(n-2) + f(n-3)+...+f(n-1-(n-1));
    上式减下式 得到 f(n)-f(n-1)=f(n-1)
    所有最终结论 f(n)=2f(n-1)
     */
    public static int frogJumpFloor2(int n) {
        int n1 = 1;
        int result = 1;
        if (n <= 1)
            return  result;
        for (int i = 2; i <= n; i++) {
            result = n1 * 2;
            n1 = result;
        }
        return result;
    }

    /*
    所以这道题的最一般情况：可以跳1、2、3、4、……、k (0<k<=n)
    f(n) = f(n-1)+f(n-2)+f(n-3)+……+f(n-k);
     */
}
