package chapter8oopintermediate.poly.exercise;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class Exercise01 {
    public static void main(String[] args) {
        double d = 13.4;// 对
        long l = (long) d;// 对
        System.out.println(l); // 是13 注意
        int in = 5;// 对
        //boolean b = (boolean)in; // 不对，boolean -> int 不能转换,boolean也不能强制转换byte
        Object obj = "Hello";// 对,向上转型
        String objStr = (String) obj; // 对，向下转型
        System.out.println(objStr); // Hello

        Object objPri = new Integer(5); //对，向上转型
        //String str = (String)objPri; // 不对，不是向下转型（如果String 是 Integer 的父类那就是；可是Integer的父类是Number）
        System.out.println(objPri instanceof String);
        Integer str1 = (Integer) objPri; // 对 是向下转型.转换后的类型就是 父类向上转型的类型
        System.out.println(str1);

        Number number = (Number)objPri;
        System.out.println(number);// 对，向下转型。转换后的类型是 父类向上转型的父类
    }
}
