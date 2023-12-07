package chapter19IO.objectstream;

/*
    演示ObjectOutputStream的使用, 完成数据的序列化
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是纯文本，而是按照他的格式来保存
        String filePath = "e:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 e:\dog.dat
        objectOutputStream.writeInt(100);//int -> Integer （Integer实现了Serializable）
        objectOutputStream.writeBoolean(true);// boolean -> Boolean (Boolean实现了 Serializable)
        objectOutputStream.writeChar('a');//char -> Character (Character实现了Serializable)
        objectOutputStream.writeDouble(9.5);// double -> Double (Double实现了 Serializable)
        objectOutputStream.writeUTF("Hello");//String(String实现了 Serializable)
        //static变量反序列化后的值是反序列化时存在于方法区的该字段的值.
        Dog.nation = "Japan";
        //保存一个Dog对象到dog.dat
        Dog dog = new Dog("xiao huang", 3, "China", "Yellow");
        //oos.writeObject(dog);是序列化自定义类 的方法
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}
