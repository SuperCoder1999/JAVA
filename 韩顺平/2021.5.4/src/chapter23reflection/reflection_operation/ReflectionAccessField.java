package chapter23reflection.reflection_operation;

import java.lang.reflect.Field;

/**
 * Class.getDeclaredField：查找该Class所有声明的属性(静态/非静态)，但是他不会去找实现的接口/父类的属性
 * Class.getField：查找该类只能是public的属性，如果找不到则往上找他的接口、父类，依次往上，直到找到或者已经没有接口/父类
 */
public class ReflectionAccessField {
    public static void main(String[] args) throws Exception {

        //1. 得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("chapter23reflection.reflection_operation.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        Student s = (Student)o;
        System.out.println(o.getClass());//Student
        //3. 使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        //Field privateName = stuClass.getField("name");//NoSuchFieldException
        //Field protectedName = stuClass.getField("nameProtected");//NoSuchFieldException
        age.set(s, 88);//通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o));//返回age属性的值

        //4. 使用反射获得name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破, 可以操作访问不到的 属性
        name.setAccessible(true);
        //name.set(o, "贾琏");
        //name.set(null, "贾琏~");//因为name是static属性，因此 o 也可以写出null
        //System.out.println(o);
        System.out.println(name.get(o)); //获取属性值
        System.out.println(name.get(null));//此方式获取属性值, 要求name是static

    }
}

class Student {//类
    public int age;
    private static String name;
    protected static String nameProtected;

    public Student() {//构造器
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}