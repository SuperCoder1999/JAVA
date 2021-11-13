package chapter25jdbc.jdbc_utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 创建 JDBC Utils类，封装JDBC的 获取连接 和关闭相关资源的 操作
 * 我认为的缺点：静态方法中 还有运行异常，只能由 JVM最后处理异常
 *
 * 或许 将这些变量初始化 放在 getConnection() 中比较好？ 或许这样会影响效率呢？
 */

public class JDBCUtilsDemo {
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
            properties.load(new FileInputStream("src/chapter25jdbc/connect/mysql.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        driver = properties.getProperty("driver");
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
    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        //顺序必须是 result -> statement -> connention
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {//或许 connection并没有被传入有效对象。甚至connection没有被赋值成功
                connection.close();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
