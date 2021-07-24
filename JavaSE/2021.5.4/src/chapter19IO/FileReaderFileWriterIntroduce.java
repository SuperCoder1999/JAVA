package chapter19IO;

/*
    FileReader 和 FileWriter 是字符流 ，即按照字符来操作io

    FileReader相关方法
    1. new FileReader(File/String)
    2. read:每次读取单个字符，返回该字符，如果是文件末尾返回-1
    3. read(char[]):批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1
    相关API：
    1. new String(char[]):将char[]转换成String
    2. new String(char[],off,len);将char[]的指定部分转换成String


    FileWriter常用方法
    1. new FileWriter(File/String):覆盖模式，相当于流的指针在首段
    2. new FileWriter(File/String,ture):追加模式，相当于流的指针在尾端
    3. write(int):写入单个字符
    4. write(char[])写入指定字符串
    5. write(char[],off,len):写入指定数组的指定部分
    6. write(String):写入整个字符串
    7. write(String, off, len)写入字符串的指定部分
    相关API
    String类，toCharArray:将String转换为char[]

    注意：FileWriter使用后，必须要关闭(close)或刷新(flush),否则写入不到指定文件
    因为这些操作只在内存中完成
 */

public class FileReaderFileWriterIntroduce {
}
