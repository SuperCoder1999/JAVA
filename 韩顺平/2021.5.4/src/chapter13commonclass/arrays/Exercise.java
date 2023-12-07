package chapter13commonclass.arrays;

import java.util.Arrays;
import java.util.Comparator;


public class Exercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃~", 300);

//        // 从大到小
//        priceSort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                double value = book2.getPrice() - book1.getPrice();
//                if (value > 0)
//                    return 1;
//                else if (value < 0)
//                    return -1;
//                else return 0;
//            }
//        });

//        // 从小到大
//        priceSort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                double value = book1.getPrice() - book2.getPrice();
//                if (value > 0)
//                    return 1;
//                else if (value < 0)
//                    return -1;
//                else return 0;
//            }
//        });

//        //书名长度从大到小
//        priceSort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                int value = book2.getName().length() - book1.getName().length();
//                if (value > 0)
//                    return 1;
//                else if (value < 0)
//                    return -1;
//                else return 0;
//            }
//        });

        //书名长度从小到大
        priceSort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                int value = book1.getName().length() - book2.getName().length();
                if (value > 0)
                    return 1;
                else if (value < 0)
                    return -1;
                else return 0;
            }
        });

        System.out.println("=======排序后=======");
        System.out.println(Arrays.toString(books));
    }

    public static void priceSort(Book[] books, Comparator c) {
        // 冒泡排序 + 定制
        for (int i = 0; i < books.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j],books[j+1]) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", price=" + price +
                '}';
    }
}