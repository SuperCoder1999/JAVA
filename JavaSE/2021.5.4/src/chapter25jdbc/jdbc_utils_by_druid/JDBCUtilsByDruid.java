package chapter25jdbc.jdbc_utils_by_druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 对 之前 JDBCUtils类 的升级
 * 1. 加入 线程池
 */
public class JDBCUtilsByDruid {
    // 使用静态方法 创建一个 DataSource。之后 getConnection() 就从这个DataSource中取

    private static DataSource dataSource = null;

    static {
        //创建出 DataSource
        Properties properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("src/chapter25jdbc/jdbc_utils_by_druid/druid-config.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
