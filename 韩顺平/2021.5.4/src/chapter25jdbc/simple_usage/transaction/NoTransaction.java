package chapter25jdbc.simple_usage.transaction;

import chapter25jdbc.simple_usage.jdbc_utils.JDBCUtilsDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示 没有开启事务 时，数据库操作 出现 数据不一致的情况
 */

public class NoTransaction {
    public static void main(String[] args) {
        //采用 JDBCUtils 框架
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //编写sql语句，马云转100给马化腾
        String sql1 = "update account set balance=balance-100 where name='马云'";
        String sql2 = "update account set balance=balace+100 where name='马化腾'";

        try {
            connection = JDBCUtilsDemo.getConnection();

            //执行第一条sql
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            System.out.println("马云 减少 100");

            //添加一个异常，导致此代码块 不能执行完全
            int a = 1 / 0;

            //执行第二条sql
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            System.out.println("马化腾 增加 100");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭 资源
            JDBCUtilsDemo.closeConnection(null, preparedStatement, connection);
            //异常不处理
        }
    }
}
