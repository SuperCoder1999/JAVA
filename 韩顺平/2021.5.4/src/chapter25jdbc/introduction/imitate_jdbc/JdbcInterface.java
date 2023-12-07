package chapter25jdbc.introduction.imitate_jdbc;

/**
 * @author 韩顺平
 * @version 1.0
 * 我们规定的jdbc接口(方法)  就是 java要求的接口，要求实现哪些功能
 */
public interface JdbcInterface {

    //连接
    public Object getConnection() ;
    //crud
    public void crud();
    //关闭连接
    public void close();
}
