package chapter25jdbc.frame.datasource.druid;

import chapter25jdbc.simple_usage.jdbc_utils.JDBCUtilsDemo;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示 Druid 的应用 以及探索连接池的使用细节.
 */

public class DruidDemo {
    public static void testGetConnections() throws Exception {
        //1. 配置 jar包 ：druid-1.1.10.jar
        //2. 添加 配置文件：格式为 .properties 名字自定义/位置自定义

        //引入 配置文件 对象
        Properties properties = new Properties();
        // 不推荐使用工作路径找资源,使用下面的类路径找资源
        // properties.load(new FileInputStream("src/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        properties.load(DruidDemo.class.getResourceAsStream("/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        // 或者:
        //properties.load(DruidDemo.class.getClassLoader().getResourceAsStream("chapter25jdbc/frame/datasource/druid/druid-config.properties"));
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

    /**
     * 将 最大连接数 都用完
     */
    @Test
    public void test() throws Exception {
        //引入 配置文件 对象
        Properties properties = new Properties();
        // 不推荐使用工作路径找资源,使用下面的类路径找资源
        // properties.load(new FileInputStream("src/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        properties.load(DruidDemo.class.getResourceAsStream("/chapter25jdbc/frame/datasource/druid/druid-config.properties"));

        //1. 获取DataSource 类
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //2. 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());

        //测试 将 最大连接数 都用完，所用的时间(时间长是因为中间需要从最小连接数扩大到最大连接数,并且扩容的方式是创建新连接)
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection1 = dataSource.getConnection();

            //不关闭连接
            //JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//14s
    }

    /**
     * 测试线程不还回线程池中的线程,会不会自动回收线程结束了的连接
     * 结论是:如果线程结束前没有关闭连接池中的连接,那么线程结束后该连接也不会还给连接池.
     */
    public static void testThreads() throws Exception {
        //引入 配置文件 对象
        Properties properties = new Properties();
        // 不推荐使用工作路径找资源,使用下面的类路径找资源
        // properties.load(new FileInputStream("src/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        properties.load(DruidDemo.class.getResourceAsStream("/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        //1. 获取DataSource 类
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 40; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Connection connection = dataSource.getConnection();
                        System.out.println(connection);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * connection还回去后,不是真的被关闭了.而是设置了其状态为关闭,必须通过下一次的dataSource.getConnection()才能重新激活该连接.
     */
    public static void testUseClosedConnection() throws Exception {
        //引入 配置文件 对象
        Properties properties = new Properties();
        // 不推荐使用工作路径找资源,使用下面的类路径找资源
        // properties.load(new FileInputStream("src/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        properties.load(DruidDemo.class.getResourceAsStream("/chapter25jdbc/frame/datasource/druid/druid-config.properties"));
        //1. 获取DataSource 类
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        //判断是否还能使用被"还回去"的连接
        System.out.println(connection);
        System.out.println(connection.createStatement());
    }

    public static void main(String[] args) throws Exception{
//        testThreads();
//        testUseClosedConnection();
        testGetConnections();
    }
}
