package chapter25jdbc.simple_usage.statement.preparestatement;

import java.sql.*;
import java.util.Scanner;

/**
 * 使用PreparedStatement执行DML操作
 */
public class PreparedStatementDML {
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
        //查询操作
        String sql = "select * from admin where name=? and pwd=?";
        //插入操作
        String sql1 = "insert into admin values(?, ?)";
        //更新数据
        String sql2 = "update admin set pwd=? where name=?";
        //删除记录
        String sql3 = "delete from admin where name=?";

        //得到PrepareStatement 实现类
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

        /*//查询
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            System.out.println("登录成功");
        else
            System.out.println("登录失败");
        resultSet.close();*/

        /*//插入
        preparedStatement1.setString(1,admin_name);
        preparedStatement1.setString(2, admin_password);
        int rows1 = preparedStatement1.executeUpdate();
        System.out.println(rows1 == 1 ? "插入成功" : "插入失败");*/

        //更新
        preparedStatement2.setString(1,admin_password);//一定要 对应 ？ (读取的时候name是name，pwd是pwd)
        preparedStatement2.setString(2, admin_name);
        int rows2 = preparedStatement2.executeUpdate();
        System.out.println(rows2 == 1 ? "更新成功" : "更新失败");

        /*//删除
        preparedStatement3.setString(1,admin_name);
        //preparedStatement3.setString(2, admin_password);
        int rows3 = preparedStatement3.executeUpdate();
        System.out.println(rows3 == 1 ? "删除成功" : "删除失败");*/


        preparedStatement.close(); // 关闭的是 PreparedStatement
        connection.close();
    }
}