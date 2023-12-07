package chapter25jdbc.simple_usage.transaction;

import chapter25jdbc.simple_usage.jdbc_utils.JDBCUtilsDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Use_Transaction {
    public static void main(String[] args) {
        //采用 JDBCUtils 框架
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //编写sql语句，马云转100给马化腾
        String sql1 = "update account set balance=balance-100 where name='马云'";
        String sql2 = "update account set balance=balance+100 where name='马化腾'";

        try {
            connection = JDBCUtilsDemo.getConnection();

            // 开启事务
            connection.setAutoCommit(false);

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

            //如果 一组DML完全执行 就commit
            connection.commit();//有异常
            System.out.println("转账成功");
        } catch (Exception e) {
            //如果 DML没有完全执行，或者commit抛出异常，都需要回滚到最开始(rollback())。rollback之后还会释放锁
            // 如果 commit 执行成功就不会有异常，也说明DML全部执行，就不会catch
            try {
                connection.rollback();//处理下异常
                System.out.println(connection.isClosed());
                System.out.println("rollback(),以上操作取消");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            /*
            commit()和rollback()和MySQL的commit/rollback命令一样,意思都是结束事务,释放锁,不会断开连接,
            只是将连接变成了普通连接,而不是具备事务功能的连接
             */
            //关闭 资源
            JDBCUtilsDemo.closeConnection(null, preparedStatement, connection);
            //异常不处理
        }
    }
}
