package chapter25jdbc.simple_usage.result_set;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class ResultSetDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //准备工作
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/chapter25jdbc/result_set/mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        String driver = properties.getProperty("driver");
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        String sql = "select id, name, sex, borndate from actor";

        //获取 ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        //遍历ResultSet
        while (resultSet.next()) {//resultSet指针原本是指向第一条记录的前面,next()方法就是判断下一条记录是否存在的.
            //getXxx()是获取当前resultSet指针指向的记录的某个字段值
            //int id = resultSet.getInt(1);//通过列的序号来
            int id = resultSet.getInt("id");//通过列名来获取，推荐
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date bornDate = resultSet.getDate("borndate"); // -- 疑问 如何知道sql中和Java中对应的类型？答:应该是开发者自己确定的
            //char sex = resultSet.getCharacterStream()  -- 即使一个字符也用String接收
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + bornDate);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
