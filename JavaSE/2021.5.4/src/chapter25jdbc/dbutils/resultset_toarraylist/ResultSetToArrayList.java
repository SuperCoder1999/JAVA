package chapter25jdbc.dbutils.resultset_toarraylist;

import chapter25jdbc.jdbc_utils_by_druid.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 使用老师的土方法来解决ResultSet =封装=> Arraylist
 */

public class ResultSetToArrayList {
    public static void main(String[] args) {
        System.out.println(testSelectToArrayList());
    }


    //使用老师的土方法来解决ResultSet =封装=> Arraylist
    public static ArrayList<Actor> testSelectToArrayList() {

        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();//创建ArrayList对象,存放actor对象
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的resultset 的记录，封装到 Actor对象，放入到list集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }

            System.out.println("list集合数据=" + list);
            for(Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + actor.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.closeConnection(set, preparedStatement, connection);
        }
        //因为ArrayList 和 connection 没有任何关联，所以该集合可以复用.
        return  list;
    }
}
