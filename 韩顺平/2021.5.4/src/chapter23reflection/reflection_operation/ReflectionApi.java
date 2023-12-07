package chapter23reflection.reflection_operation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射 的各种API
 */

public class ReflectionApi {

    //反射的常规操作流程
    public static void main(String[] args) throws Exception {
        String classFullPath = "chapter23reflection.introduction.Cat";

        //1.forName()方法 获取Cat类对应的 Class对象
        //<?> 表示不确定的Java类型 - 泛型
        Class<?> cls = Class.forName(classFullPath);

        //2. toString()方法  输出cls对应的类的数据类型 的全类名
        System.out.println(cls);
        /*
        valueOf是println()方法调用的
        public static String valueOf(Object obj) {
            return (obj == null) ? "null" : obj.toString();
        } 这里obj就是传入的cls。所以动态绑定到Class类的toString()方法中

        ---- Class的 toString()方法 ----
        public String toString() {
            return (isInterface() ? "interface " : (isPrimitive() ? "" : "class "))
                + getName();  //getName()就是得到对应类名的方法
        }
         */
        //而 cls.getClass()得到的是cls对应的数据类型。

        //3.getPackage()得到全包名、包名
        System.out.println(cls.getPackage());//得到一个全包名---含有一个 package 的头标
        System.out.println(cls.getPackage().getName());//只得到包名

        //4.得到cls对应类的类名
        System.out.println(cls.getName());

        //5.newInstance() 实例化对象
        Object o = cls.newInstance();

        //6.getField() 通过反射获取公有属性
        Field fieldName = cls.getField("name");
        System.out.println(fieldName.get(o));

        //7.fieldName.set(实例化对象, 新的参数); 给某个实例对象的某个属性赋值
        fieldName.set(o, "小花");
        System.out.println(fieldName.get(o));

        //8.getFields() 获得所有属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.get(o));
        }
    }

    //Class类中API
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException {

        //得到Class对象
        Class<?> personCls = Class.forName("chapter23reflection.reflection_operation.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());//com.hspedu.reflection.Person
        //getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());//Person
        //getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {//增强for
            System.out.println("本类以及父类的属性=" + field.getName());
        }
        //getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName());
        }
        //getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法=" + method.getName());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName());
        }
        //getConstructors: 获取所有public修饰的构造器，包含本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器=" + constructor.getName());
        }
        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名
        }
        //getPackage:以Package形式返回 包信息
        System.out.println(personCls.getPackage());//com.hspedu.reflection
        //getSuperClass:以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象=" + superclass);//
        //getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //getAnnotations:以Annotation[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);//注解
        }
    }

    // Field/Method/Constructor的API
    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {

        Class<?> personCls = Class.forName("chapter23reflection.reflection_operation.Person");
        //getDeclaredFields:获取本类中所有属性
        //getModifiers:以int形式返回修饰符
        //并规定 说明: 默认修饰符 是0 ， public  是1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        //getType:以Class形式返回类型
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }

        //Method类中的方法：
        /*
        1.getModifiers:以int形式返回修饰符。并规定: 默认修饰符 是0 ， public  是1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        2.getReturnType:以Class形式获取返回类型
        3.getParameterTypes:以Class[]返回 该方法的所有参数 对应的类型数组
         */
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        //Constructor类中的方法
        /*
        1.getModifiers:以int形式返回修饰符
        2.getName:返回构造器名（全类名）
        3.getParameterTypes:以Class[] 返回该构造器的所有参数 对应的类型数组
         */
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }

    }
}

class A {
    public String hobby;

    public void hi() {

    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {

    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }

    private void m4() {

    }
}
