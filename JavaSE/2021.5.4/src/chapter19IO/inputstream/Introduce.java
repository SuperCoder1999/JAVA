package chapter19IO.inputstream;

/*
    一：流的分类
    1. 按照操作数据单位不同分为：字节流(8bit)二进制文件（适用于音频、图像等文件），字符流（按字符）适用于
    文本文件。
    2. 按照数据流的流向分为：输入流，输出流
    3. 按照流的角色的不同分为：节点流，处理流/包装流

    抽象基类    字节流          字符流
    输入流     InputString     Reader
    输出流     OutputStream    Write

    二：
    1. Java的IO流共设计40多个类，实际上非常规则，都是从如上4个抽象基类派生出来的
    2. 由这四个类派生出的子类名称都是以其父类名作为子类名后缀。
 */

public class Introduce {
}
