package chapter25jdbc.simple_usage.batch_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示 批处理
 */

public class BatchUsage {
    public static void main(String[] args) {
        // 准备工作：url中添加 rewriteBatchedStatements=true参数 - 这个参数下，也可以不进行 批处理
        // 由于 JDBCUtils 中properties包写死了，需要改connect下的properties
        // 使用JDBCUtils 事务 框架

        System.out.print("程序执行：");
        Long start = System.currentTimeMillis();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "insert into admin2 values(null, ?, ?)"; // 很神奇，不加 ; 分号

        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, "" + i);
                preparedStatement.setString(2, "123");

                //添加到 批处理包
                preparedStatement.addBatch();

                if ((i + 1) % 1000 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            connection.commit();
            System.out.println("添加成功");

            Long end = System.currentTimeMillis();
            System.out.println("程序结束：" + (end - start));//1205ms

        } catch (Exception e) {
            try {
                connection.rollback();
                System.out.println("有异常，之前操作全部取消");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(e);
        } finally {
            JDBCUtils.closeConnection(null, preparedStatement, connection);
        }
    }
}
