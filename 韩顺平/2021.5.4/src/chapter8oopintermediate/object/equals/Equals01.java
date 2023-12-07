package chapter8oopintermediate.object.equals;

/*
    一： ' == '
    1. 既可以判断基本类型也可以判断引用类型
    2. 如果判断基本类型，就是判断值是否相等
    3. 如果判断引用类型，就是判断两个对象内存地址/运行类型是否相等（判断是否是同一个对象）
 */
public class Equals01 {
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = b1;
        B b3 = b2;
        System.out.println(b1 == b3);

        A a = b1;
        System.out.println(b2 == a);
        /*
        二：equals方法在不同引用类型中的源码和具体作用
           1. Object中
            public boolean equals(Object obj) {
                return (this == obj);
            }
            即判断两个对象内存地址/运行类型是否相等（判断是否是同一个对象），等同于 ==

            2. String中
            public boolean equals(Object anObject) {
                if (this == anObject) {
                    return true;
                }
                if (anObject instanceof String) {
                    String anotherString = (String)anObject;
                    int n = value.length;
                    if (n == anotherString.value.length) {
                        char v1[] = value;
                        char v2[] = anotherString.value;
                        int i = 0;
                        while (n-- != 0) {
                            if (v1[i] != v2[i])
                                return false;
                            i++;
                        }
                        return true;
                    }
                }
                return false;
            }
            即先判断是否是同一对象，不是之后再判断是否每一个字符相同

            3. Integer中
            public boolean equals(Object obj) {
                if (obj instanceof Integer) {
                    return value == ((Integer)obj).intValue();
                }
                return false;
            }
            即判断两者值是否相等

         */
    }
}

class A {}
class B extends A {}