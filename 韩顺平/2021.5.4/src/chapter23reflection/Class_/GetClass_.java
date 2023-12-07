package chapter23reflection.Class_;

import chapter23reflection.introduction.Cat;

/**
 * 演示得到Class对象的各种方式(6)
 */

public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName. 配置文件指定类
        String classAllPath = "chapter23reflection.introduction.Cat"; //开发中是通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 类名.class , 应用场景: 知道类名,可以用于参数传递
        Class cls2 = Cat.class;
        System.out.println(cls2);

        //3. 对象.getClass(), 应用场景，有对象实例
        Cat cat = new Cat();
        Class cls3 = cat.getClass();
        System.out.println(cls3);

        //4. 通过类加载器【4种】来获取到类的Class对象
        //(1)先得到应用程序类加载器,可以通过任何自定义类对象获取该应用程序加载器,或通过
        GetClass_ instance = new GetClass_();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader systemClassLoader1 = instance.getClass().getClassLoader();
        ClassLoader systemClassLoader2 = GetClass_.class.getClassLoader();
        ClassLoader extClassLoader = systemClassLoader.getParent();
        ClassLoader bootstrapClassLoader = String.class.getClassLoader();//bootstrap加载器无法被获取,始终为NULL
        //ClassLoader systemClassLoader3 = cat.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        //Class cls4 = extClassLoader.loadClass(classAllPath);//加载不了自定义类对象
        Class<?> cls4 = systemClassLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1 , cls2 , cls3 , cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5. 基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE; //其它包装类BOOLEAN, DOUBLE, LONG,BYTE等待
        System.out.println(type1);

        System.out.println(integerClass.hashCode());//
        System.out.println(type1.hashCode());//这两者输出相同，int会自动装箱为Integer
    }
}