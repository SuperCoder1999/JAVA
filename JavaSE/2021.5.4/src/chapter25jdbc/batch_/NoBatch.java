package chapter25jdbc.batch_;

import chapter25jdbc.jdbc_utils.JDBCUtilsDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 在没有 批处理的程序中 插入 500数据
 * 和 Batch_程序 做对比
 */

public class NoBatch {
    public static void main(String[] args) {

        //url中添加了 rewriteBatchedStatements=true参数 - 这个参数下，也可以不进行 批处理

        // 由于 JDBCUtils 中properties包写死了，需要改connect下的properties
        // 使用JDBCUtils 事务 框架

        System.out.print("程序执行：");
        Long start = System.currentTimeMillis();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "insert into admin2 values(null, ?, ?)"; // Java中的 sql不加 ; 分号

        try {
            connection = JDBCUtilsDemo.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 500; i++) {
                preparedStatement.setString(1, "" + i);
                preparedStatement.setString(2, "123");
                //每生成一个 就执行一个

                preparedStatement.executeUpdate();
            }
            connection.commit();
            System.out.println("添加成功");

            Long end = System.currentTimeMillis();
            System.out.println("程序结束：" + (end - start));//500 数据 要 16s

        } catch (Exception e) {
            try {
                connection.rollback();
                System.out.println("有异常，之前操作全部取消");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(e);
        } finally {
            JDBCUtilsDemo.closeConnection(null, preparedStatement, connection);
        }
    }
}