package chapter3variablequantity.auto_convert_detail;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/16 18:13
 * Description long类型可以自动转换为float类型
 * 1.虽然long是8个字节,float是4个字节,但是float[2^(-149)~~(2-2^(-23))*2^127]的计数范围比long(-2^63~2^63-1)大,long也没有小数位
 */
public class LongToFloat {
    public static void main(String[] args) {
        long l = 1000;
        float f = l;
        System.out.println(f);
    }
}
