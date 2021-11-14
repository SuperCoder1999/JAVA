package chapter25jdbc.dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 创建 工具类 ：JDBCUtilsByDruid 提供连接池 、断开连接 的 操作
 */
public class JDBCUtilsByDruid {
    //配置文件druid-config.properties 就绪

    //1.创建 Properties 引用。

    private static Properties properties = null;
    private static DataSource dataSource = null;

    static {

        try {
            //在静态方法中 导入properties 文件对象
            properties = new Properties();
            properties.load(new FileInputStream("src/chapter25jdbc/dao/utils/druid-config.properties"));

            //创建 DataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch(Exception e) {
            throw new RuntimeException(e);
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
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
