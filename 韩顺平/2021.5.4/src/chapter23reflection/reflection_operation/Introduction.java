package chapter23reflection.reflection_operation;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 一：介绍 反射的大概操作 以及 常用到的类
 *  1.java.lang.Class:代表一个类，Class对象表示某个类加载后在堆中的对象
 *  2.java.lang.reflection.Method:代表类的方法，Method对象表示某个类的方法
 *  3.java.lang.reflection.Field:代表类的成员变量，Field对象表示某个类的成员变量
 *  4.java.lang.reflection.Constructor:代表类的构造器，Constructor对象表示某个类的构造器
 */

public class Introduction {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\chapter23reflection\\introduction\\re.properties"));
        String classfullpath = (String)properties.get("classfullpath");
        String methodName = properties.get("method1").toString();

        //1.java.lang.Class 返回Class类型的对象cls。且可以得到cls中的方法getMethod、成员属性getField、构造器getConstructor
        Class cls = Class.forName(classfullpath);
        //1.2通过Class类型的对象cls 创建一个对象cls对应的类的对象
        Object o = cls.newInstance();
        System.out.println(o);

        Method method = cls.getMethod(methodName);
        //2.java.lang.reflection.Method 使用由Class获取的类的方法
        // (因为这里方法是每个对象都有的，所以具体使用哪个对象要使用method.invoke(对象名)
        method.invoke(o);

        Field nameFiled = cls.getField("name");
        //3.java.lang.reflection.Field 使用由Class获得的类的成员属性
        // (因为这里属性是每个对象都有的，所以具体使用哪个属性要使用nameField.get(对象名)
        System.out.println(nameFiled.get(o));

        Constructor constructor = cls.getConstructor();//()中可以指定构造器参数类型, 这里返回的是无参构造器
        //4.java.lang.reflection.Constructor 使用由Class类获得的类的构造器
        //这里并不知道怎么使用构造器，所以使用的方式就暂时不管了
        System.out.println(constructor);

        //指定构造器参数类型。指定的方式就是传入 构造器参数类型对应的Class类对象
        Constructor constructor1 = cls.getConstructor(String.class);//这里传入的 String.class 就是String类的Class对象
        System.out.println(constructor1);//Cat(String.lang.String)
    }
}
