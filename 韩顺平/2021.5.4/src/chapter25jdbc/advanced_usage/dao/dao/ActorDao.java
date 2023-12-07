package chapter25jdbc.advanced_usage.dao.dao;

import chapter25jdbc.advanced_usage.dao.domain.Actor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActorDao extends BasicDao<Actor> {
    //继承了 BasicDao 通用操作
    //也可以添加 特殊操作

    /**
     * 针对Actor表的插入操作
     */
    public boolean insertBean(Actor actor) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthDay = sdf.format(actor.getBornDate());
        String sql = "insert into actor values(null,?,?,?,?)";
        int rows = super.update(sql, actor.getName(), actor.getSex(), birthDay, actor.getPhone());
        return rows == 1;
    }
}
