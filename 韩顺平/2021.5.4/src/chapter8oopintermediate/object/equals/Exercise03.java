package chapter8oopintermediate.object.equals;

public class Exercise03 {
    /*
    t
    t
    t
    f
    t
    f
     */
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;
        System.out.println(it == fl);
        char ch1 = 'A';
        char ch2 = 12;
        System.out.println(it == ch1);
        System.out.println(12 == ch2);// 这里ch2 Ascii码就是12,而不是说ch2是字符 12
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        // System_.out.println("Hello" == new C()); == 不能用于不同类型的对象
    }
}

class C {
}
