package chapter19IO.properties;



import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.CheckedInputStream;

/**
 * 读取 properties文件
 */
public class PropertiesReader {
    /*
    一：基本介绍
    1. properties的常见方法
        load：加载配置文件的键值到Properties对象
        list：将数据显示到指定设备
        getProperty(key):根据键值获取值
        setProperty(key, value)：设置键值对应的Properties对象【如果没有这个对象，就直接创建了】
        store:将properties中的键值对存储到配置文件，在idea中，保存信息到
        配置文件，如果有中文，会存储为Unicode
 */

    public static void main(String[] args) throws IOException {
        // 使用Properties类来读取mySql.properties文件

        //1. 创建Properties对象
        Properties properties = new Properties();
        //2. 加载指定配置文件流
        properties.load(new FileReader("src\\chapter19IO\\mySql.properties"));
        //3. 把k-v显示在控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        System.out.println("用户名：" + user);
    }
}
