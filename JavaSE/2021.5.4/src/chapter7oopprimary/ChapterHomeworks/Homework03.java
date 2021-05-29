package chapter7oopprimary.ChapterHomeworks;

/*
    编写类Book,  定义方法updatePrice，实现更改某本书的价格，
    具体：如果价格>150,则更改为150，如果价格>100,更改为100，否则不变
 */
public class Homework03 {
    public static void main(String[] args) {
        Book aBook = new Book(190);
        aBook.updatePrice();
        System.out.println(aBook.price);// 可以封装成方法，每次调用即可
        Book bBook = new Book(111);
        bBook.updatePrice();
        System.out.println(bBook.price);
        Book cBook = new Book(19);
        cBook.updatePrice();
        System.out.println(cBook.price);
    }
}

class Book {

    double price;

    public Book(double price) {
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150)
            this.price = 150;
        else if (this.price > 100)
            this.price = 100;
    }
}