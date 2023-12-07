package chapter8oopintermediate.object;

import java.util.TreeSet;

/**
 * 一：重写equals()和hashCode()
 * 1. 代码规范中建议：当两个对象的equals()方法比较返回true时，这两个对象的 hashCode()方法的返回值也应相等。也就是说hashCode()方法重写时尽量保证对象内容相同时返回的hashcode相同.
 * 这样做也符合HashMap对于key的存储要求,如果key是一个对象,而对象内容相同就可以看作是重复key,就没必要再存入了,而是覆盖原来的value.
 * 2. Idea自动重写equals和hashCode中，实现了上面的建议。
 * 3. Idea如何实现不同对象，hashCode和equals保持相同结果,hashCode重写就应该是根据对象内容计算的:
 *  1.String类中的hashCode()方法对于 相同的字符串调用hashCode()方法，得到的值是一样的，与内存地址、进程、机器无关。
 *  2.非引用类型，直接比较数据。引用类型再调用其hashCode()方法(递归)。
 */
public class OverrideEqualsHashCode {
    public static void main(String[] args) {
        User user = new User(12, "123");
        User user2 = new User(12, "123");
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());//相等
    }
}

class User {
    private int age = 10;
    private String name = "Tom";


    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        //String类中的hashCode()方法对于 相同的字符串调用hashCode()方法，得到的值是一样的，与内存地址、进程、机器无关。
        return result;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}