package chapter23reflection.reflection_operation;

import chapter23reflection.User;
import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.Constructor;

/**
 *  演示通过反射得到各种构造器 创建对象实例
 *  暴力破解，使用反射可以访问private构造器/方法/属性
 */

public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception {
        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("chapter23reflection.User");

        //2. 通过可访问到的无参构造器创建实例
        Object o = userClass.newInstance();
        User u = (User)o;
        System.out.println(u);

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
        //强转后可以直接调用对象方法
        User u1 = (User)o1;
        u1.setName("张三");
        System.out.println(o1);

        //4. 通过非public的有参构造器创建实例
        //4.1先得到相应构造器,此时得到的构造器是访问不到的。需要暴力破解，使用反射可以访问 访问不到的构造器/方法/属性
        //4.2再传入实参到构造器创建对象
        Constructor<?> c2 = userClass.getDeclaredConstructor(int.class, String.class);
        c2.setAccessible(true);
        Object o2 = c2.newInstance(20, "林黛玉");
        System.out.println(o2);

        Constructor<?> c3 = userClass.getDeclaredConstructor(int.class);
        //c2.setAccessible(true);//default修饰的构造器也要破解.破解的原则是访问不到就需要
        Object o3 = c3.newInstance(20, "宝钗");
        System.out.println(o2);
    }
}

