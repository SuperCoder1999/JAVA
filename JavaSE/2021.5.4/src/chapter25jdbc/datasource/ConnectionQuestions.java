package chapter25jdbc.datasource;

import chapter25jdbc.jdbc_utils.JDBCUtilsDemo;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * 演示 传统方式连接数据库 的弊端
 * 1. 耗时
 * 2. 连接过多
 */

public class ConnectionQuestions {
    //代码 连接mysql 5000次
    @Test
    public void testCon() {

        //看看连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的jdbc方式，得到连接
            Connection connection = JDBCUtilsDemo.getConnection();
            //做一些工作，比如得到PreparedStatement ，发送sql
            //..........
            //如果不关闭 报错：too many connection
            //关闭
            JDBCUtilsDemo.closeConnection(null, null, connection);

        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次 耗时=" + (end - start));//传统方式5000次 耗时=7099
    }
}
