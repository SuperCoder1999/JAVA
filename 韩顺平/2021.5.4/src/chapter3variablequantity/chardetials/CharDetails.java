package chapter3variablequantity.chardetials;

/**
 * 最小值是 \u0000（即为0），也是默认值
 * 最大值是 \uffff（即为65,535）
 *
 * 有一个误区：负数可以在强转后赋值给char
 * 1.实际底层强转的时候就已经将符号位看作为数值位了。
 */
public class CharDetails {
    public static void main(String[] args) {
        System.out.println((char)0xffff);
        System.out.println((char)65535);
        char ch1 = 65535;
        ch1 += 66;//char类型，溢出规律是：超出后，从头开始
        System.out.println((char)65);//A
        System.out.println(ch1);//A
        //char ch11 = 65539;//赋值时，编译器自动检查范围，超出范围的就认为是int类型。
        char ch2 = (char)-32;//这种赋值-32必须加强制转换，本质上还是将-32的符号位看作为数值位
        char ch3 = (char)-32768;//这种赋值-32768必须加强制转换，本质上还是将-32768的符号位看作为数值位
        System.out.println((char)-32768);//耀
    }
}
