package chapter15genetic.generic_erasure;

import java.lang.reflect.Method;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/30 12:24
 * Description 擦除接口泛型时的细节
 * 1.擦除接口泛型的规则和参数类泛型一样
 * 2.细节在于其实现类中
 *  1)实现类中产生桥接方法,原因:
 *  比如接口中的泛型用于声明方法的返回类型,编译期被擦除成Object,
 *  则实现类中原本对该方法的实现方法就可能不满足对擦除后抽象方法的实现.
 *  此时会生成一个桥接方法,实现"擦除后接口中的抽象方法"
 */
public class ErasureGenericInterface {
    public static void main(String[] args) {
        Class<InfoImpl> infoClass = InfoImpl.class;
        //获取所有的方法
        Method[] infoImplMethods = infoClass.getDeclaredMethods();
        for (Method method : infoImplMethods) {
            //打印方法名和方法的返回值类型。
            /**
             * 输出:
             * info:Integer
             * info:Object --这个就是桥接方法
             */
            System.out.println(method.getName() + ":" + method.getReturnType().getSimpleName());
        }
    }
}

interface Info<T> {
    T info(T t);
}
class InfoImpl implements Info<Integer> {
    @Override
    public Integer info(Integer value) {
        return value;
    }
}