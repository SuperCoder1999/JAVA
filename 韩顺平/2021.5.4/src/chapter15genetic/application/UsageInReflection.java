package chapter15genetic.application;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/30 15:36
 * Description 泛型在反射中的应用
 * 1.此外泛型在设计模式中应用也很多
 */
public class UsageInReflection {

    //反射中使用泛型,优点
    public static void test() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();//直接获得想要的类的实例
    }

    //反射中没有使用泛型
    public static void test02() throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor();
        Object o = constructor.newInstance();//还需要进行类型转换
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}