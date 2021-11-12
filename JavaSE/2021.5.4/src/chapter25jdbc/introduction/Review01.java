package chapter25jdbc.introduction;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 对 JDBC的快速入门 代码 复习
 */
public class Review01 {

    public static void main(String[] args) throws SQLException {
        //1.注册驱动 - 加载Driver类
        Driver driver = new Driver();
        Properties properties = new Properties();
        String url = "jdbc:mysql://123.57.92.107:3306/hsp_db02";
        properties.setProperty("user", "root");
        properties.setProperty("password", "N331150871");

        Connection connection = driver.connect(url,properties);

        Statement statement = connection.createStatement();

        String sql = "insert into actor values (null, '刘德华', '男', '1970-11-11', '110')";

        boolean key = statement.execute(sql);
        if (key)
            System.out.println("插入失败");
        else
            System.out.println("插入成功");

        System.out.println("连接：" + connection);

        //关闭连接  不能忘
        statement.close();
        connection.close();

    }
}
