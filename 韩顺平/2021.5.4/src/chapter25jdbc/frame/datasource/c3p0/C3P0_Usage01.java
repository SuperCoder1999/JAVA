package chapter25jdbc.frame.datasource.c3p0;

import chapter25jdbc.simple_usage.jdbc_utils.JDBCUtilsDemo;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示 C3P0 的 第一种 使用方式: 在程序中指定相关连接 参数
 * 需要配置文件 c3p0-0.9.1.2.jar
 */

public class C3P0_Usage01 {
    public static void main(String[] args) throws IOException, SQLException, PropertyVetoException {
        // 1. 获取数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //2. 配置 连接 信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/chapter25jdbc/connect/mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化 连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //3. 获取连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        JDBCUtilsDemo.closeConnection(null, null, connection);
        //测试 5000次连接时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //获取连接
            Connection connection1 = comboPooledDataSource.getConnection();

            //关闭连接
            JDBCUtilsDemo.closeConnection(null, null, connection1);
            System.out.println("使用完毕连接: " + i);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//967ms
    }

    /**
     * 将 最大连接数 都用完
     */
    @Test
    public void test() throws IOException, PropertyVetoException, SQLException {
        // 1. 获取数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //2. 配置 连接 信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/chapter25jdbc/simple_usage/connect/mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化 连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置对打连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //测试 将 最大连接数 都用完，所用的时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection1 = comboPooledDataSource.getConnection();

            //关闭连接
            //JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//5s

        //其中 含有 扩大连接池 的时间。
    }
}
