package WinterHomeworks2021.day03.choices;

import org.junit.jupiter.api.Test;

public class Test1 {
    public static void main(String args[]) {
        byte a = 3;
        byte b = 2;
        a+=b;  //复合赋值运算符可以避免 byte的自动转换
        System.out.println(a);//5
        System.out.println(b);//2
    }

    public void testB() {
        byte a = 127;
        byte b = 126;
        //b = a + b; //普通的 +  号会报错.因为byte运算时自动转换为int
        System.out.println(b);
    }

    @Test
    public void testD() {
        byte a = 127;
        byte b = 127;
        a+=b;
        System.out.println(a);//-2
        System.out.println(b);
    }
}
