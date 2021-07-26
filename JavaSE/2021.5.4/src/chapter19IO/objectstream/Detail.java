package chapter19IO.objectstream;

/*
    一：细节：
    1. 读写顺序要一致
    2. 要求序列化或反序列化对象需要实现 Serializable
    3. 序列化的类中简易添加SerialVersionUID，为了提高版本的兼容性
    4. 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
    5. 序列化对象时，要求里面属性的类型也需要实现序列化接口（那些int之类的属性都是会转化为包装类并且其包装类实现了Serializable)
    6. 序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化

 */

public class Detail {
}
