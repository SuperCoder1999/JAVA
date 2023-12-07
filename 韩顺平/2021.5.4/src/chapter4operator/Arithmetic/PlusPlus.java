package chapter4operator.Arithmetic;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/9 18:06
 * Description 算数运算符 之 自增"++"的细节
 * 1.自增原理(字节码指令):
 *  1.X++，会将X自身值先保存下来留待之后作为表达式结果，然后对X+1，然后将保存结果赋值给左边。
 *      count = count++  原理是 temp = count； count = count+1 ； count = temp；   因此count始终是0
 *  2.而count = ++count 原理是  count = count+1 ； temp = count； count = temp；
 */
public class PlusPlus {
    public static void main(String[] args) {
        int a = 1;
        a = a++;
        System.out.println(a);//1
    }
}
