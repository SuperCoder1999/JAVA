package chapter14jihe.homeworks;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        List list = new ArrayList(); // 这里引用类型换成ArrayList也可以
        New new1 = new New("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        New new2 = new New("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        list.add(new1);
        list.add(new2);

        Collections.reverse(list);//如果使用普通for循环，可以不用reverse()

        //迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            New n = (New) obj;
            if (n.getTitle().length() > 15) {
                System.out.println(n.getTitle().substring(0, 15) + "...");// [0,14)就是15个元素
                //应该写一个方法，返回一个String，新的String是拼接成的结果
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if(((New)list.get(i)).getTitle().length() > 15) {
                System.out.println(((New) list.get(i)).getTitle().substring(0, 15) + "...");
            }
        }
    }
}

class New {
    private String title;
    private String text;

    public New(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                "\'}";
    }
}