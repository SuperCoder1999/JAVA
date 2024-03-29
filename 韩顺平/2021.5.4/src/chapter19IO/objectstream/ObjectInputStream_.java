package chapter19IO.objectstream;

//import chapter19IO.objectstream.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String filePath = "e:\\dog.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //老师解读
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致
        //2. 否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());

        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());


        //dog 的编译类型是 Object , dog 的运行类型是 Dog
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        ////static变量反序列化后的值是反序列化时存在于方法区的该字段的值.
        Dog.nation = "Japan";
        System.out.println("dog信息=" + dog);//底层 Object -> Dog
        //dog信息=Dog{name='小黄', age=3, color='null'}null chapter19IO.objectstream.Master@17a7cec2
        //Master没有属性，所以就打印出了其哈希值

        //这里是特别重要的细节:

        //1. 如果我们希望调用Dog的方法, 需要向下转型
        //2. 需要我们将Dog类的定义，放到当前java文件可以引用的位置
        //3. 注意：序列化和反序列化的类必须是同一个.因为dog.dat文件中有具体的包地址,复制后的类和原来序列化所用类被认为是不同的
//            Dog dog2 = (Dog)dog;
//            System.out.println(dog2.getName()); //旺财..

        //关闭流, 关闭外层流即可，底层会关闭 FileInputStream 流
        ois.close();
    }
}