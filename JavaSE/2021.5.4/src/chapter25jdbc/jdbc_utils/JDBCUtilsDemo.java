package chapter25jdbc.jdbc_utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 创建 JDBC Utils类，封装JDBC的 获取连接 和关闭相关资源的 操作
 * 1. 感觉这封装 也不是很好呢。配置文件 在静态方法中写死了。
 * 2. 静态方法中 还有运行异常，只能由 JVM最后处理异常
 *
 * 或许 将这些变量初始化 放在 getConnection() 中比较好
 */

public class JDBCUtilsDemo{
    // 基本属性
    private static String user = null;
    private static String password = null;
    private static String url = null;
    private static String driver = null;

    //初始化 基本属性
    static {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/chapter25/connect/mysql.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        user = properties.getProperty("user");
        password= properties.getProperty("password");
        url= properties.getProperty("url");
        driver= properties.getProperty("driver");
    }

    //获取 连接
    public static Connection getConnection() {
        try {
            //这里 我写了 反射
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e1) {
            throw new RuntimeException(e1);
        } catch (SQLException e2) {
           throw new RuntimeException(e2);
        }
    }

    //关闭连接
    public static void closeConnection(ResultSet set, Statement statement) {

    }
}
