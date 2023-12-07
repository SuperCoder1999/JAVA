package WinterHomeworks2022.CAndJava.Program.Day03;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 16:06
 * Description 递归
 *             => 皮球知道第一次落地高度,反弹为落地高度的1/2.求第10次落地经过路程,以及第10次反弹高度
 *             => 递归 适用于知道起始值,并且知道后续变化和起始值关系
 * 1.题目: 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 * 2.代码可以优化为,计算第n次落地前经历路程和第n次反弹高度
 */
public class Solution01 {
    //循环方式
    public static void main(String[] args) {
        double distanceCount = 0;
        double firstFallDistance = 100;
        double reboundHeight = firstFallDistance / 2;
        //计算路径,除了第一次落地,其他反弹高度都要计算两次,因为反弹多高就下落多高
        distanceCount += firstFallDistance;
        for (int i = 1; i < 10; i++) {
            distanceCount += reboundHeight;
            if (i != 0) {
                distanceCount += reboundHeight;
            }
            reboundHeight /= 2;
        }
        System.out.println("第十次落地前经历路程: " + distanceCount + "m");
        System.out.println("第十次反弹: " + reboundHeight + "m");
        //测试 次数为3: 结果 "经历: 250.0m 第3次反弹: 12.5m" 经过画图验证,正确
    }
}

//递归方式,递归过程中,无法累计路程,只能通过成员属性累计路程
class Solution01_01 {
    //直接将经过的路程初始化100, 因为反弹路程和落下路程相同,所以可以作为一组进行计算,第一次落下路径就单独拿出来计算了
    // 如果次数低于1次,那就return 0就行
    private static double distanceCount = 100;

    public static void main(String[] args) {
        //测试 次数为3: 结果 "第3次落地前经历路程: 250.0m  第3次反弹: 12.5m" 经过画图验证,正确
        int times = 3;
        //如果次数是1,就不会有反弹
        if (times == 0) {
            System.out.println("第0次落地前经历路程: " + 0 + "m");
            System.out.println("第0次反弹: " + 0 + "m");
        } else {
            //通过递归计算第n次反弹高度,并累计路程
            double finalReboundHeight = reboundHeight(times);
            //因为累计路程过程中,将第n次反弹落下的路径也计算了,所以要去除掉
            double distanceCount = Solution01_01.distanceCount - 2 * finalReboundHeight;
            System.out.println("第" + times + "次落地前经历路程: " + distanceCount + "m");
            System.out.println("第" + times + "次反弹: " + finalReboundHeight + "m");
        }
    }

    //因为知道起始值,并且知道后续变化和起始值关系,所以可以用递归
    public static double reboundHeight(int times) {
        double reboundHeight = 0;
        //如果是第一次反弹,高度是已知的
        if (times == 1) {
            reboundHeight = 50;
        }
        //如果非首次反弹,高度是上一次的一半
        else {
            reboundHeight = reboundHeight(times - 1) / 2;
        }
        //因为路程中,反弹多高就下落多高,所以反弹高度都要计算两次
        distanceCount += 2 * reboundHeight;
        return reboundHeight;
    }
}