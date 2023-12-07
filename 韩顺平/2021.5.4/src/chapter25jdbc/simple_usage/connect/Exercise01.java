package chapter25jdbc.simple_usage.connect;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 课堂练习
 * 1. 使用连接方式五
 * 2. 创建一个news表
 * 3. 使用jdbc添加 5条记录
 * 4. 修改id=1记录，改成 你的名字
 * 5. 删除id=3记录
 */
public class Exercise01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        // 1. 使用连接方式五
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/chapter25jdbc/connect/mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //反射加载类
        Class<?> aclass = Class.forName(driver);
        //这里的两步 静态代码 完成的
        Driver driver1 = (Driver)aclass.newInstance();
        DriverManager.registerDriver(driver1);

        Connection connection = DriverManager.getConnection(url, user, password);

        //获取 statement对象，用于执行 命令
        Statement statement = connection.createStatement();

        //2. 创建一个news表
        String sql1 = "create table news(id int primary key auto_increment, title varchar(32) not null default'') ";
        //statement.execute(sql1);
        //3. 使用jdbc添加 5条记录
        String sql2 = "insert into news values (null, 'title01'), (null, 'title01')," +
                "(null, 'title01'),(null, 'title01'),(null, 'title01')";
        //statement.execute(sql2);
        //4. 修改id=1记录，改成 你的名字
        String sql3 = "update news set title='你的名字' where id=1 ";
        //statement.execute(sql3);
        //5. 删除id=3记录
        String sql4 = "delete from news where id=3 ";
        statement.execute(sql4);

        statement.close(); // 注意
        connection.close();
    }
}
