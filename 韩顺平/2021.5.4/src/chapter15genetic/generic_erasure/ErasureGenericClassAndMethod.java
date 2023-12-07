package chapter15genetic.generic_erasure;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/30 11:56
 * Description 泛型擦除泛型类/泛型方法中的泛型
 * 1.类泛型/方法泛型没有限制时,编译期间泛型被擦除为Object类型
 * 2.类泛型/方法泛型规定上限类型时,擦除为上限类型
 */
public class ErasureGenericClassAndMethod {
    public static void main(String[] args) throws ClassNotFoundException {
        test03();
    }

    //类泛型没有限制时,编译期间泛型被擦除为Object类型
    public static void test01() {
        Erasure<Integer> erasure = new Erasure<>();
        //利用反射，获取Erasure类的字节码文件的Class类对象
        Class<? extends Erasure> clz = erasure.getClass();
        //获取所有的成员变量
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //打印成员变量的名称和类型
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }
        System.out.println("----------------------------------------------------------------");
        //获取所有的方法
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //打印方法名和方法的返回值类型。
            /**
             * 方法泛型规定上限类型时,擦除为上限类型
             */
            System.out.println(declaredMethod.getName() + ":" + declaredMethod.getReturnType().getSimpleName());
        }
    }

    //对于使用泛型为<?>的引用变量为引用变量赋值时,泛型都是Object类型
    public static void test03() throws ClassNotFoundException {
        ArrayList<?> list = new ArrayList<>();
        Test test = new Test<>(list);
        //利用反射，获取Test类的字节码文件的Class类对象
        Class<?> clz = test.getClass();
        //获取所有的成员变量
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //打印成员变量的名称和类型
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }
        System.out.println("----------------------------------------------------------------");
        //获取所有的方法
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //打印方法名和方法的返回值类型。
            System.out.println(declaredMethod.getName() + ":" + declaredMethod.getReturnType().getSimpleName());
        }
    }

    //类泛型规定上限类型时,擦除为上限类型
    public static void test02() {
        ErasureGenericSuperiorLimit<Integer> erasure = new ErasureGenericSuperiorLimit<>();
        //利用反射，获取Erasure类的字节码文件的Class类对象
        Class<? extends ErasureGenericSuperiorLimit> clz = erasure.getClass();
        //获取所有的成员变量
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //打印成员变量的名称和类型
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }
        System.out.println("----------------------------------------------------------------");
        //获取所有的方法
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //打印方法名和方法的返回值类型。
            System.out.println(declaredMethod.getName() + ":" + declaredMethod.getReturnType().getSimpleName());
        }
    }
}

class Erasure<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 泛型方法
     */
    public <U> U show(U u) {
        return u;
    }
}
class ErasureGenericSuperiorLimit<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 泛型方法
     */
    public <U extends List> U show(U u) {
        return u;
    }
}

class Test<T>  {

    public Test(List<T> type) {
    }


    public T handle(T t) throws SQLException {
        return t;
    }
}