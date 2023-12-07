package chapter25jdbc.simple_usage.batch_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 创建 JDBC Utils类，封装JDBC的 获取连接 和关闭相关资源的 操作
 * (jdbc只是一个规范,这里的连接方式用的是MySQL提供的jdbc实现类API,还没有连接池等功能)
 *
 * 或许 将这些变量初始化 放在 getConnection() 中比较好？ 或许这样会影响效率呢？
 */

public class JDBCUtils {
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

            properties.load(new FileInputStream("src/chapter25jdbc/simple_usage/batch_/mysql.properties"));
        } catch (IOException e) {
            System.out.println(e);
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
        } catch (ClassNotFoundException | SQLException e1) {
            throw new RuntimeException(e1);
        }
    }

    //关闭连接
    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        //顺序必须是 result -> statement -> connection
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
