package chapter25jdbc.connect;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 复习 连接 的五种方式
 */
public class Review01 {
    public static void main(String[] args) {

    }

    @Test
    public void connect01() throws SQLException {
        //第一种，静态加载 Driver
        Driver driver = new Driver();

        Properties properties = new Properties();
        String url = "jdbc:mysql://123.57.92.107:3306/hsp_db02";
        properties.setProperty("user", "root");
        properties.setProperty("password", "N331150871");

        //driver类 仅支持 url+Properties
        Connection connection = driver.connect(url, properties);

        System.out.println("方式一：" + connection);
        connection.close();
    }

    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //反射 获取 创建Driver
        Class aclass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aclass.newInstance();

        Properties properties = new Properties();
        String url = "jdbc:mysql://123.57.92.107:3306/hsp_db02";
        properties.setProperty("user", "root");
        properties.setProperty("password", "N331150871");

        Connection connection = driver.connect(url, properties);

        System.out.println("方式二：" + connection);
        connection.close();
    }

    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //使用 DriverManager  利用Driver注册
        Class aclass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aclass.newInstance();

        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://123.57.92.107:3306/hsp_db02?user=root&password=N331150871");

        System.out.println("方式三：" + connection);
        connection.close();
    }

    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        // 因为Driver类中 有一个静态代码块是注册Driver的。
        // 所以可以省略DriverManager.registerDriver(driver);
        // 并且，如果是采用 反射机制  则不需用创建Driver对象了。利用反射也会自动加载要反射的类

        Class aclass = Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://123.57.92.107:3306/hsp_db02?user=root&password=N331150871");

        System.out.println("方式四：" + connection);
        connection.close();
    }
}

// 时间不够了 其余代码 等待复习