package chapter19IO;

/*
    节点流和处理流
    一：基本介绍
    1. 节点流可以从一个特定的数据源读写数据，如FileReader、FileWriter
    2. 处理流（也叫包装流）是“链接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，
    如BufferReader、BufferedWriter
    3. BufferedReader类中，有属性Reader，即可以封装一个节点流，该节点流可以是任意的，只要是Reader子类

    二：节点流 有：访问文件、访问数组、访问管道、访问字符串

    三：节点流和处理流的区别和联系
    1. 节点流是底层流、低级流，直接跟数据源相接
    2. 处理流（包装流）包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输入
    3. 处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连【模拟修饰器设计模式】

    四：节点流的功能主要体现在以下两个方面
    1. 性能提高：主要以增加缓冲的方式来提高输入输出的效率
    2. 操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便

 */

public class NodeVSHandle {
}
