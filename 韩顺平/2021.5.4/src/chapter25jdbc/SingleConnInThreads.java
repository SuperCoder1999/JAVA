package chapter25jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 多线程中,共用一个Connection
 * 1.进程是多线程的情况下,共用一个连接是可以支持无事务的操作的.
 * 2.致命问题是一个业务将连接开启事务后,其他的业务的操作会在这个"事务"中出现,一旦回滚,其他业务的命令都没了
 */
public class SingleConnInThreads {
    public static void main(String[] args) throws SQLException, InterruptedException {

        //前置工作： 在项目下创建一个文件夹比如 libs
        // 将 mysql.jar 拷贝到该目录下，点击 add to project ..加入到项目中
        //1. 注册驱动
        Driver driver = new Driver(); //创建driver对象

        //2. 得到连接
        // 老师解读
        //(1) jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost 主机，可以是ip地址
        //(3) 3306 表示mysql监听的端口
        //(4) hsp_db02 连接到mysql dbms 的哪个数据库
        //(5) mysql的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://123.57.92.107:3306/hsp_db02?useSSL=false";
        //String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将 用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "N331150871"); //密码
        Connection connect = driver.connect(url, properties);


        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                for (int i1 = 0; i1 < 10; i1++) {
                    Statement statement = null;
                    //3. 执行sql
                    String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
                    //String sql = "update actor set name='周星驰' where id = 1";
                    //String sql = "delete from actor where id = 1";
                    //statement 用于执行静态SQL语句并返回其生成的结果的对象
                    int rows = 0;
                    try {
                        statement = connect.createStatement();
                        rows = statement.executeUpdate(sql); // 如果是 dml语句，返回的就是影响行数
                        System.out.println(Thread.currentThread().getName() + (rows > 0 ? "成功" : "失败"));
                        statement.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }, "Thread " + i).start();
        }

        new Thread(() -> {
                Statement statement = null;
                //3. 执行sql
                String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
                //String sql = "update actor set name='周星驰' where id = 1";
                //String sql = "delete from actor where id = 1";
                //statement 用于执行静态SQL语句并返回其生成的结果的对象
                int rows = 0;
                try {
                    statement = connect.createStatement();
                    rows = statement.executeUpdate(sql); // 如果是 dml语句，返回的就是影响行数
                    System.out.println(Thread.currentThread().getName() + (rows > 0 ? "成功" : "失败"));
                    Thread.sleep(100 * 1000);
                    statement.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
        }, "Thread main").start();

        Thread.sleep(100 * 1000);
        //4. 关闭连接资源
        connect.close();
    }
}
