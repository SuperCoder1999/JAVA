package chapter14jihe.homeworks;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class Homework06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();//ok
        Person p1 = new Person(1001,"AA");//ok
        Person p2 = new Person(1002,"BB");//ok
        set.add(p1);//ok
        set.add(p2);//ok
        p1.name = "CC"; // set的table中存的是对象地址，是引用，而不是复制。
            // 所以这里table中原本的{1001,"AA"}的空间内容被更改为：{1001,"CC"};
        System.out.println(set.remove(p1));
        // 注意：这里删除的时候和存入时一样，都有计算hash值（计算hash值和重写的hashCode()有关）的过程。
        // 此时通过p1计算的hash值和原本的不一样了
            // 因此，删除位置也不一样，就找不到和目前p1相同的对象，因此删除失败。
        System.out.println(set);//2
        set.add(new Person(1001,"CC"));
            // 这里虽然和 当前的p1 一样。但是当前p1存放table位置是 之前的p1状态下的table位置
        System.out.println(set);//3
        set.add(new Person(1001,"AA"));
            // 这里找到了之前p1所在的table位置，但是经过对象比较后（hash值不一样、equals也不等）不等，则加到了这个链表上
        System.out.println(set);//4

    }
}

class Person {
    public String name;
    public int id;

    public Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}