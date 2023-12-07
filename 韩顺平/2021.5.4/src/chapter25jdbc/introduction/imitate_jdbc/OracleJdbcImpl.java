package chapter25jdbc.introduction.imitate_jdbc;

/**
 * @author 韩顺平
 * @version 1.0
 * 模拟oracle数据库实现 jdbc - 和mysql 实现的内容都是一样的，都是实现接口jdbcinterface中的那些方法
 */
public class OracleJdbcImpl implements  JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("得到 oracle的连接 升级");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 对oracle的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 oracle的连接");
    }
}
