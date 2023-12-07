package chapter25jdbc.simple_usage.statement;

import java.sql.*;
import java.util.Scanner;

/**
 * 演示 Statement SQL注入风险
 *
 * 恶意攻击 ：请输入管理员的名字: 1' OR
 *          请输入管理员的密码: OR '1'='1
 */
public class StatementDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://123.57.92.107:3306/hsp_db02?user=root&password=N331150871");
        Statement statement = connection.createStatement();

        //获取 客户端输入信息：
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入管理员的名字: ");
        String admin_name = scanner.nextLine();
        System.out.print("请输入管理员的密码: ");
        String admin_password = scanner.nextLine();

        String sql =
                "select * from admin where name='" + admin_name + "' and pwd='" + admin_password +"'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next())
            System.out.println("登录成功");
        else
            System.out.println("登录失败");

        resultSet.close();
        statement.close();
        connection.close();
    }
}
