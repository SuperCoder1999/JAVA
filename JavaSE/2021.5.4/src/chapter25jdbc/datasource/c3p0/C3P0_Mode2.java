package chapter25jdbc.datasource.c3p0;

import chapter25jdbc.jdbc_utils.JDBCUtilsDemo;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *  演示 C3P0 的第二种 使用方式
 *  需要相应的jar包 c3p0-0.9.1.2.jar
 *
 *  关于配置文件中 的那两个 参数 不太明白
 */
public class C3P0_Mode2 {
    public static void main(String[] args) throws SQLException {
        //1. 通过配置文件 获取 数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0_demo01");
        //这个函数 只能接收 configName

        //获取连接
        Connection connection = comboPooledDataSource.getConnection();
        //关闭连接
        JDBCUtilsDemo.closeConnection(null, null, connection);

        //测试 5000次连接时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection1 = comboPooledDataSource.getConnection();

            //关闭连接
            JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//1326ms
    }

    @Test
    public void test() throws SQLException {
        //1. 通过配置文件 获取 数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0_demo01");
        //这个函数 只能接收 configName

        //获取连接
        Connection connection = comboPooledDataSource.getConnection();
        //关闭连接
        JDBCUtilsDemo.closeConnection(null, null, connection);

        //测试 将 最大连接数 都用完，所用的时间
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection1 = comboPooledDataSource.getConnection();

            //关闭连接
            //JDBCUtilsDemo.closeConnection(null, null, connection1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);//6s
    }

    @Test
    public void test2() {
        //想 搞明白 那两个参数
        // <!-- 可连接的最多的命令对象数 -->
        // <property name="maxStatements">5</property>
        //
        // <!-- 每个连接对象可连接的最多的命令对象数 -->
        // <property name="maxStatementsPerConnection">2</property>

        // 是不是 指 PreparedStatement的数量？

    }
}
