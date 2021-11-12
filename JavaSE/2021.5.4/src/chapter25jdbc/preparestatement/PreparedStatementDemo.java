package chapter25jdbc.preparestatement;

import java.sql.*;
import java.util.Scanner;

/**
 * 不用Statement  而用 PrepareStatement
 */

public class PreparedStatementDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //借用Statement中的准备代码
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

        //含有占位符 ？ 的sql语句
        String sql = "select * from admin where name=? and pwd=?";

        //得到PrepareStatement 实现类
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //sql 只有 全权 由 PreparedStatement对象 进行 补充
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_password);

        ResultSet resultSet = preparedStatement.executeQuery();// 这里不能有sql

        if (resultSet.next())
            System.out.println("登录成功");
        else
            System.out.println("登录失败");

        resultSet.close();
        preparedStatement.close(); // 关闭的是 PreparedStatement
        connection.close();
    }
}
