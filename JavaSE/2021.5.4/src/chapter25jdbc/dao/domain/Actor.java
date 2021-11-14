package chapter25jdbc.dao.domain;

import java.util.Date;

/**
 * Actor 类 和Actor表对应
 */
public class Actor {// JavaBean、POJO、Domain对象
    private int id;
    private String name;
    private String sex;
    private Date bornDate;
    private String phone;

    public Actor() {//无参构造器 一定要有【反射需要】

    }

    public Actor(int id, String name, String sex, Date bornDate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.bornDate = bornDate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", bornDate=" + bornDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
