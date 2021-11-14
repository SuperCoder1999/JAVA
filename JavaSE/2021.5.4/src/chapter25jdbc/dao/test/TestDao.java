package chapter25jdbc.dao.test;

import chapter25jdbc.dao.dao.ActorDao;
import chapter25jdbc.dao.domain.Actor;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ActorDao actorDao = new ActorDao();

        String sql1 = "insert into actor values(null,?,?,?,?)";
        int rows = actorDao.update(sql1, "宫本", "男", "1234-10-19", "12345");
        System.out.println(rows == 1 ? "插入成功" : "插入失败");

        /*String sql2 = "select * from actor";
        List<Actor> list = actorDao.queryMulti(sql2, Actor.class);
        System.out.println(list);*/
    }
}
