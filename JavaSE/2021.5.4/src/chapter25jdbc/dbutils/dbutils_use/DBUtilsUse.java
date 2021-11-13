package chapter25jdbc.dbutils.dbutils_use;

import chapter25jdbc.dbutils.resultset_toarraylist.Actor;
import chapter25jdbc.jdbc_utils_by_druid.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 演示使用 apache.commons-dbutils工具
 */
public class DBUtilsUse {
    //1. 配置 commons-dbutils.jar 包

    //演示 dbutils 多行查询 获取 结果集的ArrayList数组  - 使用JDBCUtilsByDruid 工具类
    @Test
    public void testQueryMany() throws SQLException {
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
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        //5. 处理 得到的结果
        System.out.println(list);
        for (Actor actor : list) {
            System.out.println(actor.getId() + "\t" + actor.getName() + "\t" +
                    actor.getSex() + "\t" + actor.getBorndate() + "\t" + actor.getPhone());
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
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 11);

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
        //2.编写sql
        String sql = "select * from actor where id=?";
        //3.创建QueryRunner类
        QueryRunner queryRunner = new QueryRunner();

        //4.调用queryRunner.query()方法执行查询语句
        //返回值 为 JavaBean实例
        Object scalar = queryRunner.query(connection, sql, new ScalarHandler(), 1);

        //5.处理结果
        System.out.println(actor);
        if (actor != null)
            System.out.println(actor.getId() + "\t" + actor.getName() + "\t" +
                    actor.getSex() + "\t" + actor.getBorndate() + "\t" + actor.getPhone());

        //6.关闭 资源
        JDBCUtilsByDruid.closeConnection(null, null, connection);
    }
}
