package chapter8oopintermediate.object.equals;


public class Exercise02 {
    public static void main(String[] args) {

        Person_ p1 = new Person_();
        p1.name = "hspedu";

        Person_ p2 = new Person_();
        p2.name = "hspedu";

        System.out.println(p1==p2); //False
        System.out.println(p1.name .equals( p2.name));//T
            //注意这里调用的是String方法中的equals方法。
        System.out.println(p1.equals(p2));//False，这是继承Object中的equals方法

        String s1 = new String("asdf");

        String s2 = new String("asdf");
        System.out.println(s1.equals(s2));//T
        System.out.println(s1==s2); //F

    }
}

class Person_{//类
    public String name;
}