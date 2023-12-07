package chapter14jihe.collection_.IterateOverCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    一：Collection接口遍历元素方式1 - 使用 Iterator（迭代器）

    二：Iterator介绍：
    1. Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
    2. 所有实现了Collection接口的集合类(List\Set)都有iterator()方法，用以返回一个实现了Iterator接口
    的对象，即返回一个迭代器
    3. Iterator仅用于遍历集合，Iterator本身并不用于存放对象
 */

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));


        //System.out.println("col=" + col);
        //现在老师希望能够遍历 col集合
        //1. 先得到 col 对应的 迭代器
        Iterator iterator = col.iterator();
        //2. 使用while循环遍历
//        while (iterator.hasNext()) {//判断是否还有数据
//            //返回下一个元素，类型是Object； 由于迭代器开始时指向的是第一个元素前面的位置，所以第一个元素也会输出
//            Object obj = iterator.next(); // obj的运行类型看真正的类型
//            System.out.println("obj=" + obj); // 这里就动态绑定到Book中的toString方法了
//        }
        //老师教大家一个快捷模板键，快速生成 while (iterator.hasNext()) => itit
        //显示所有的快捷模板的的快捷键 ctrl + j
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }
        //3. 当退出while循环后 , 这时iterator迭代器，指向最后的元素
        //   iterator.next();//如果指向了最后一个元素继续取元素则报错 NoSuchElementException
        //4. 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

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
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}