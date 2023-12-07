package chapter25jdbc.advanced_usage.jdbc_utils_by_druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试 通过druid连接池创建的Jdbc工具类
 */
public class JDBCUtilsByDruid_Use {
    public static void main(String[] args) {
        //testDML();
        select();
    }

    public static void testDML() {

        //获取连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into actor(name, sex) values(?, ?)";//没有异常，也写在外面吧

        try {
            connection = JDBCUtilsByDruid.getConnection();//有异常

            preparedStatement = connection.prepareStatement(sql);//有异常

            preparedStatement.setString(1, "沈思蕊");//有异常
            preparedStatement.setString(2, "女");//有异常

            int rows = preparedStatement.executeUpdate();//有异常
            System.out.println(rows == 1 ? "插入成功" : "插入失败");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtilsByDruid.closeConnection(null, preparedStatement, connection);
            //有异常,就不处理了(或者说，在上一层就已经处理了异常)
        }
    }

    public static void select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id, name, sex from actor where sex=?";//没有异常，也写在外面吧
        try {
            connection = JDBCUtilsByDruid.getConnection();//有异常
            System.out.println(connection);

            preparedStatement = connection.prepareStatement(sql);//有异常

            preparedStatement.setString(1, "女");//有异常

            resultSet = preparedStatement.executeQuery();//有异常

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                System.out.println("查询后的数据: " + id + "\t" + name + "\t" + sex);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtilsByDruid.closeConnection(resultSet, preparedStatement, connection);
            //有异常,就不处理了(或者说，在上一层就已经处理了异常)
        }
    }
}