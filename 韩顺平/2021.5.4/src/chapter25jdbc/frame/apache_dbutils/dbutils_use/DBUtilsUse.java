package chapter25jdbc.frame.apache_dbutils.dbutils_use;

import chapter25jdbc.frame.apache_dbutils.Actor;
import chapter25jdbc.advanced_usage.jdbc_utils_by_druid.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 演示使用 apache.commons-dbutils工具.这个工具在以后,都被mybatis代替了
 *
 * 工具的优化:
 * 1.对ResultSet的优化:询出来的数据集合就是List对象,所以可以直接用自己定义的List变量,引用返回的集合.就不需要再像ResultSet一样手动转存到ArrayList中
 * 2.对PrepareStatement的优化: 不用创建PrepareStatement对象,底层自己创建; 不需要调用setInt()/setString(),只需要提供对应参数
 */
public class DBUtilsUse {
    //1. 配置 commons-dbutils.jar 包

    //演示 dbutils 多行查询 获取 结果集的ArrayList数组  - 使用JDBCUtilsByDruid 工具类
    @Test
    public void testQueryMany() throws SQLException, ClassNotFoundException, InstantiationException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.编写 sql语句
        String sql = "select * from actor where id>=?";
        //疑问：为什么其他列会 显示null？？？
        //String sql2 = "select id, name from actor where id>=?";
        // 可能因为 没有ResultSet到Actor对象读取到这些列？所以显示的时候是null。但是又是什么控制 Actor实例接收那些参数？

        //3.创建QueryRunner 类
        QueryRunner queryRunner = new QueryRunner();

        //4. 使用 QueryRunner类中的 query()方法 执行查询语句
//        Class<Actor> clazz = Actor.class;
//        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), 1);

        //纯反射方式
        Class<?> clazz = Class.forName("chapter25jdbc.frame.apache_dbutils.Actor");
        List<?> list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), 1);

        //5. 处理 得到的结果
        for (Object actor : list) {
            System.out.println(actor);
//            System.out.println(actor.getId() + "\t" + actor.getName() + "\t" +
//                    actor.getSex() + "\t" + actor.getBorndate() + "\t" + actor.getPhone());
        }
        //6. 关闭 资源
        JDBCUtilsByDruid.closeConnection(null, null, connection);
    }

    //演示 dbutils 单行查询 获取 单个记录 - 使用JDBCUtilsByDruid 工具类
    @Test
    public void testQuerySingle() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.编写sql
        String sql = "select * from actor where id=?";
        //3.创建QueryRunner类
        QueryRunner queryRunner = new QueryRunner();

        //4.调用queryRunner.query()方法执行查询语句
        //返回值 为 JavaBean实例
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<Actor>(Actor.class), 1);

        //5.处理结果
        System.out.println(actor);
        if (actor != null)
            System.out.println(actor.getId() + "\t" + actor.getName() + "\t" +
                    actor.getSex() + "\t" + actor.getBorndate() + "\t" + actor.getPhone());

        //6.关闭 资源
        JDBCUtilsByDruid.closeConnection(null, null, connection);
    }

    //演示 dbutils 单行单列 查询 获取 一个 Object类的对象  - 使用JDBCUtilsByDruid 工具类
    @Test
    public void testScalar() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.创建QueryRunner类
        QueryRunner queryRunner = new QueryRunner();

        //3.编写sql
        String sql = "select name from actor where id=?";

        //4.调用queryRunner.query()方法执行查询语句
        //返回值 为 Object - 也可以向下转型
        Object scalar = queryRunner.query(connection, sql, new ScalarHandler(), 9);

        //5.处理结果
        System.out.println(scalar);

        //6.关闭 资源
        JDBCUtilsByDruid.closeConnection(null, null, connection);
    }

    //演示 dbutils 实现 DML操作(增删改) - 使用JDBCUtilsByDruid 工具类
    @Test
    public void testDML() throws SQLException {
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2. 编写 sql
        String sqlInsert = "insert into actor values(null, ?, ?, ?, ?)";
        String sqlUpdate = "update actor set name=? where id=?";
        String sqlDelete = "delete from actor where id=?";

        //3. 创建 QueryRunner 类
        QueryRunner queryRunner = new QueryRunner();

        // 测试各个方法
        //testDMLInsert(connection,sqlInsert, queryRunner);
        testDMLUpdate(connection, sqlUpdate, queryRunner);
        testDMLDelete(connection, sqlDelete, queryRunner);

        //5. 释放资源
        JDBCUtilsByDruid.closeConnection(null, null, connection);
    }
    public void testDMLInsert(Connection connection, String sql, QueryRunner queryRunner) throws SQLException {
        //4. 调用 QueryRunner.update() 方法 执行 DML
        int rows = queryRunner.update(connection, sql, "林青霞", "女", "1999-10-10", "116");

        System.out.println(rows == 1 ? "插入成功" : "插入失败");
    }
    public void testDMLUpdate(Connection connection, String sql, QueryRunner queryRunner) throws SQLException {
        //4. 调用 QueryRunner.update()方法 执行DML
        int rows = queryRunner.update(connection, sql, "华仔", 1);

        System.out.println(rows == 1 ? "修改成功" : "修改没有影响到表");
    }
    public void testDMLDelete(Connection connection, String sql, QueryRunner queryRunner) throws SQLException {
        //4. 调用 QueryRunner.update()方法 执行DML
        int rows = queryRunner.update(connection, sql,  10);

        System.out.println(rows == 1 ? "删除成功" : "删除没有影响到表");
    }
}
