package chapter23reflection.introduction;

/*
    1.反射的引入：如果只给了含有一个类、方法的配置文件及这个类所实现的包。要求在程序中使用这个类。
    2.并且做到，修改类的信息及配置文件内容后，程序中引用的对象方法都不受影响。
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Introduction {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //1.使用Properties类，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\chapter23reflection\\introduction\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method1").toString();

        //2.如果单纯用之前的 new Cat()方式。则需要如下：
        // new classfullpath();  --- 但是这样是行不通的

        //3.所以引出反射机制解决
        // 1)(手动加载类到底什么时候创建好的Class对象，我有些糊涂) 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        // 2)通过cls得到 你加载的类 chapter23reflection.introduction.Cat 的对象实例
        Object o = cls.newInstance();
        // 3)通过cls得到 你加载的类 的方法对象。【也可以通过创建的对象实例调用方法】
        /*Cat c = (Cat)o;
        c.cry();*/
        Method method1 = cls.getMethod(methodName);
        method1.invoke(o);
    }
}
