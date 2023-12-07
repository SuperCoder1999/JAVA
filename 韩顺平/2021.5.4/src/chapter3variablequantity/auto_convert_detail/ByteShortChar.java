package chapter3variablequantity.auto_convert_detail;


public class ByteShortChar {
    public static void main(String[] args) {

        // 示例一 直接赋值
        byte b1 = 100;
        byte b2 = 100 + 1;//编译后被赋的值就是 加法运算的结果
        //byte b2 = 1000; //会报错,因为1000超过byte范围.


        // 示例二 自动提升类型
        /*
         * byte short char 三者可以计算,在计算时首先转换为int类型
         */
        byte b3 = 1;
        byte b4 = 2;
        short s1 = 1;
        //short s2 = b3 + s1;//错, b2 + s1 => int
        int i2 = b3 + s1;//对, b2 + s1 => int
        //byte b5 = b3 + b4; //错误: b2 + b3 => int


        // 示例三 final的编译优化
        /*
        2022年9月21日富士通(西安)笔试
        解释:1.final已经将byte类型的变量转换为常量.
            2.进行运算的是两个常量，此时先计算数值的大小运算，然后再判断是否满足类型范围，满足之后再进行赋值.
            即示例一中的情况.
         */
        short ss1 = 1, ss2 = 2, ss3, ss6, ss8;
        final byte fb4 = 4, fb5 = 6, fb7, fb10;
        char cc1 = 10;

        //bb3 = (bb1 + bb2); //这个是错的.选他

        ss6 = fb4 + fb5; //本质:short被赋值常量.即ss6=4+6;

        int bb9 = ss1 + fb4; //本质 bb9=ss1+6;

        fb7 = (fb4 + fb5);//本质 fb7=4+6;

        cc1 = fb4; //本质 cc1 = 4;

        System.out.println(ss1 + fb4);

        System.out.println((4 < 1) ^ (6 > 3)); // true


        // 示例四 复合赋值运算符
        byte a = 3;
        byte b = 2;
        a += b;  //复合赋值运算符可以避免 byte的自动转换(原因:+=操作符会进行隐式自动类型转换.
        //此处a+=b隐式地将相加操作的计算结果强制转化为持有结果的类型，即a的类型byte
        System.out.println(a);//5
        System.out.println(b);//2

        //验证+=的隐式强制转换
        int m = 1;
        byte n = 2;
        n += m;
        System.out.println(n);//3
        System.out.println(getType(n));//byte
        System.out.println(m);//1

        byte a11 = 127;
        byte b11 = 127;
        a11+=b11;//就是byte中-127+1+126，其中-127+1为-128.所以结果为-2
        b11 += 1;
        System.out.println(b11);//-128
        System.out.println(a11);//-2
    }

    // 获取当前变量类型:
    // 通过下面的重载的方式
    public static String getType(Object o) {
        return o.getClass().toString();
    }

    public static String getType(int o) {
        return "int";
    }

    public static String getType(byte o) {
        return "byte";
    }

    public static String getType(char o) {
        return "char";
    }

    public static String getType(double o) {
        return "double";
    }

    public static String getType(float o) {
        return "float";
    }

    public static String getType(long o) {
        return "long";
    }

    public static String getType(boolean o) {
        return "boolean";
    }

    public static String getType(short o) {
        return "short";
    }

    public static String getType(String o) {
        return "String";
    }
}
