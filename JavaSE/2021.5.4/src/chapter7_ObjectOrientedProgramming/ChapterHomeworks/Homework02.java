package chapter7objectorientedprogrammingprimary.ChapterHomeworks;

public class Homework02 {
    public static void main(String[] args) {
        A02 aA02 = new A02();
        System.out.println(aA02.find("niejian"));
        System.out.println(aA02.find("Smith"));
    }
}

class A02 {
    String[] strings = {"jack", "tom", "milan", "Smith"};
    public int find(String findString) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(findString))
                return i;
        }
        return -1;
    }
}