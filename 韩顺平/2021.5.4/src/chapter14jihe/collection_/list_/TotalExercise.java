package chapter14jihe.collection_.list_;
import java.util.*;
public class TotalExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }
        System.out.println("==================");
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (((Book)list.get(j)).getPrice() > ((Book)list.get(j + 1)).getPrice()) {
                    Object temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                    flag = false;
                }
            }
            if (flag)
                break;
        }

        for (Object obj : list) {
            System.out.println(obj);
        }

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t价格:" + price + "\t\t作者：" + author;
    }
}