package chapter15genetic.homeworks;

//import org.junit.jupiter.api.Test; 不适合用JUnit

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User("小红", 123, 19));
        userDAO.save("002", new User("king",2,18));
        userDAO.save("003", new User("smith",3,38));


        System.out.println("002:" + userDAO.get("002"));

        userDAO.update("003", new User("Jack", 31, 23));

        System.out.println("所有User：" + userDAO.list());

        userDAO.delete("1");

        System.out.println(userDAO.all());
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();// 每次new一个 DAO 就创建该对象中的 map

    public void save(String id, T entity) {
        map.put(id,entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        /*
        间接获得 values

        Set<String> keySet = map.keySet();
        List<T> list = new ArrayList<>();
        for (String s : keySet)
            list.add(get(s));
         */

        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        int i = 0;
        for(T t : values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public Map<String, T> all() {
        return map;
    }
}

class User {
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}