package chapter23reflection.reflectionfunction;

import java.lang.reflect.Constructor;

/**
 *  演示通过反射得到各种构造器 创建对象实例
 *  暴力破解，使用反射可以访问private构造器/方法/属性
 */

public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception {
        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("chapter23reflection.reflectionfunction.User");

        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //3. 通过public的有参构造器创建实例
        //3.1先得到相应构造器
        //3.2再传入实参到构造器创建对象
        Constructor<?> c1 = userClass.getConstructor(String.class);
        /*
        此时，c1构造器就等同于
        public User(String name) {//public的有参构造器
            this.name = name;
        }
        这样就解释的通，为什么在反射中用无参构造器创建对象，不用获取Constructor。
        */
        Object o1 = c1.newInstance("贾宝玉");
        System.out.println("通过有参构造器创建对象" + o1);

        //4. 通过非public的有参构造器创建实例
        //4.1先得到相应构造器,此时得到的构造器也是私有的。需要暴力破解，使用反射可以访问private构造器/方法/属性
        //4.2再传入实参到构造器创建对象
        Constructor<?> c2 = userClass.getDeclaredConstructor(int.class, String.class);
        c2.setAccessible(true);
        Object o2 = c2.newInstance(20, "林黛玉");
        System.out.println(o2);
    }
}

class User { //User类
    private int age = 10;
    private String name = "Tom";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}