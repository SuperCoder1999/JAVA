package chapter25jdbc.datasource.druid;

import chapter25jdbc.jdbc_utils.JDBCUtilsDemo;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示 Druid 应用实例
 * 不知道 为什么，没有用完连接池 的 耗时很短，比视频中的短很多
 * 但是 用完连接池 连接 耗时 很大
 */

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1. 配置 jar包 ：druid-1.1.10.jar
        //2. 添加 配置文件：格式为 .properties 名字自定义。位置自定义

        //引入 配置文件 对象
        Properties properties = new Properties();
        properties.load
                (new FileInputStream("src/chapter25jdbc/datasource/druid/druid-config.properties"));

        //1. 获取DataSource 类
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //2. 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());// 查看当前类实例 是 哪个类型
        //3. 关闭连接
        JDBCUtilsDemo.closeConnection(null, null, connection);

        //测试 500000次连接时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            Connection connection1 = dataSource.getConnection();

            //关闭连接
            JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//5000:12ms and 5000,000 : 559ms
    }

    @Test
    public void test() throws Exception {
        //引入 配置文件 对象
        Properties properties = new Properties();
        properties.load
                (new FileInputStream("src/chapter25jdbc/datasource/druid/druid-config.properties"));

        //1. 获取DataSource 类
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //2. 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());
        //3. 关闭连接
        JDBCUtilsDemo.closeConnection(null, null, connection);

        //测试 将 最大连接数 都用完，所用的时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection1 = dataSource.getConnection();

            //关闭连接
            //JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//14s
    }
}
