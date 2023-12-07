package chapter25jdbc.advanced_usage.dao.test;

import chapter25jdbc.advanced_usage.dao.dao.ActorDao;
import chapter25jdbc.advanced_usage.dao.domain.Actor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestDao {

    private static final ActorDao actorDao = new ActorDao();

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthDay = "2000-11-8 5:20:00";
        Date date = sdf.parse(birthDay);
        boolean res = actorDao.insertBean(new Actor(0, "宫本", "男", date, "12345"));
        System.out.println(res ? "插入成功" : "插入失败");
    }

    public static void test02() {
        String sql2 = "select * from actor";
        List<Actor> list = actorDao.queryMulti(sql2, Actor.class);
        System.out.println(list);
    }
}
