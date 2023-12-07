package chapter25jdbc.introduction.imitate_jdbc;

/**
 * @author 韩顺平
 * @version 1.0
 * description 模拟Java的JDBC框架
 */
public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();


        //完成对oracle的操作
        System.out.println("==============================");
        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();

    }
}
