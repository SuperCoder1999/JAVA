package chapter4operator.BitwiseOperator;

/**
 * 位运算符 之 逻辑右移
 * 1.测试逻辑右移>>>会移动符号位吗？ 答案是：符号位也会移动
 */
public class LogicalShiftRight {
    public static void main(String[] args) {
        //测试无符号右移>>>会移动符号位吗？ 答案是：符号位也会移动
        System.out.println(-2>>>1);
        // 1000 0000 0000 0000 0000 0000 0000 0010(原码) ->
        // 1111 1111 1111 1111 1111 1111 1111 1110(补码) =>
        // 0111 1111 1111 1111 1111 1111 1111 1111(右移后) ---- 2,147,483,647(十进制)
    }
}
