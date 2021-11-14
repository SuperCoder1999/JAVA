package chapter25jdbc.dao.dao;

import chapter25jdbc.dao.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/**
 * 创建 数据连接对象 类 的 父类。将各个Dao中共同的操作写在这里
 */
public class BasicDao<T> {//泛型 继承这个方法的时候 可以指定 子类中 对象类型.用于校验 这个类中方法参数
    //需要用到 dbutils+JDBCUtilsByDruid

    //创建一个 QueryRunner对象 够用吗？
    private QueryRunner queryRunner = new QueryRunner();

    //通用的方法，针对各个表 的DML操作
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();//有异常
            int rows = queryRunner.update(connection, sql, parameters);
            return rows;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null, null, connection);
        }
    }

    //通用的方法，针对各个表 进行 多行查询 操作
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null, null, connection);
        }
    }

    //通用方法
}
