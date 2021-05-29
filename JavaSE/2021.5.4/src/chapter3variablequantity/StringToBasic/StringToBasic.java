package chapter3variablequantity.StringToBasic;

public class StringToBasic {
    public static void main(String[] args) {

        //基本数据类型 -> String
        System.out.println("---基本数据类型 -> String---");
        int n1 = 100;
        float f1 = 1.1f;
        double d1 = 4.5;
        boolean b1 = true;
        String s1 = n1 + "";
        String s2 = f1 + "";
        String s3 = d1 + "";
        String s4 = b1 + "";
        System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);

        //String -> 基本数据类型
        String s5 = "123";
        //学完OOP，理解基本类、函数后再来细细琢磨
        int num1 = Integer.parseInt(s5);
        double num2 = Double.parseDouble(s5);
        float num3 = Float.parseFloat(s5);
        long num4 = Long.parseLong(s5);
        byte num5 = Byte.parseByte(s5);
        short num6 = Short.parseShort(s5);
        boolean num7 = Boolean.parseBoolean("true");

        System.out.println("---String -> 基本数据类型---");
        System.out.println(num1);//123
        System.out.println(num2);//123.0
        System.out.println(num3);//123.0
        System.out.println(num4);//123
        System.out.println(num5);//123
        System.out.println(num6);//123
        System.out.println(num7);//ture
        //num7 也不是很明显
        //利用num7 ，体现转换
        if (!num7) System.out.println("true");
        else System.out.println("false");

        //将字符串转化为字符char
        System.out.println("---将字符串转化为字符char---");
        System.out.println(s5.charAt(0));
    }
}
