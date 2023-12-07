package chapter23reflection.reflection_operation;

import java.lang.reflect.Method;

public class ReflectionAccessMethods {
    public static void main(String[] args) throws Exception {

        //1. 得到Boss类对应的Class对象
        Class<?> bossCls = Class.forName("chapter23reflection.reflection_operation.Boss");
        //2. 创建对象
        Object o = bossCls.newInstance();
        //3. 获取public的hi方法对象
        //Method hi = bossCls.getMethod("hi", String.class);//OK
        // 获取static的方法对象
        Method sayStatic = bossCls.getMethod("sayStatic", int.class);
        System.out.println(sayStatic);//OK
        //3.1 得到hi方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);//OK
        //3.2 调用
        Object invoke = hi.invoke(o, "韩顺平教育~");
        System.out.println("invoke方法的返回值: " + invoke);

        //4. 调用访问不到的 static 方法
        //4.1 得到 say 方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2 因为say方法是访问不到的, 所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        //4.3 因为say方法是static的，还可以这样调用 ，可以传入null
        System.out.println(say.invoke(null, 200, "李四", '女'));

        //5. 在反射中，如果方法有返回值，统一返回Object(向上转型了) , 但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());//String

        //再演示一个返回的案例
        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2的运行类型=" + reVal2.getClass());//Monster

        // void方法反射调用invoke()后返回值为null
        Method m2 = bossCls.getMethod("testVoid");
        Object invokeVoid = m2.invoke(o);
        System.out.println("void方法返回值: " + invokeVoid);
    }
}

class Monster {}

class Boss {//类
    public int age;
     static String name;

    public Boss() {//构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {//静态私有方法
        return n + " " + s + " " + c;
    }

    public static String sayStatic(int n) {//静态方法
        return n + "";
    }

    public void hi(String s) {//普通public方法
        System.out.println("hi " + s);
    }

    public void testVoid() {
        System.out.println("testVoid()");
    }
}