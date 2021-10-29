package homeworks.h20210926;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test9 {

    public static void main(String[] args) {
        int[][] arr = {{1,1}, {1,-1}, {2,0},{2,-1}};
        System.out.println(asylum(arr));
    }

    public static ArrayList<Integer> asylum(int[][] ope) {
        /*
        1.创建三个队列，第一个存放所有入栈元素。第二个存放整数元素，第三个存放负数元素。
        (1.可以用一个数组完成，即每次都从前到后遍历一遍；2.也可以只用两个队列分别存储整数和负数，但是对于
        每个对象都需要记录其序号，将两个队列最前面的对象的序号比较后即可直到谁是最前面的。)
        2.遍历到什么条件就将对应队列出队

        错误操作可能存在第一个元素、第二个元素。真的不好排除
         */
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> positiveLinkedList = new LinkedList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        LinkedList<Integer> negativeLinkedList = new LinkedList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {//第一个元素是 1 的情况
                if (ope[i][1] == 1) {
                    positiveLinkedList.add(1);
                    integerLinkedList.add(1);
                }
                else {
                    negativeLinkedList.add(-1);
                    integerLinkedList.add(-1);
                }
            } else if (ope[i][0] == 2) {//第二个元素是 2
                if (ope[i][1] == 0) {
                    list.add(integerLinkedList.pop());
                } else if (ope[i][1] == 1)
                    list.add(positiveLinkedList.pop());
                else
                    list.add(negativeLinkedList.pop());
            } else {
                throw new RuntimeException("错误操作");
            }
        }
        return list;
    }
}

class AnimalShelf {

    LinkedList<Integer[]> anyList = null;
    LinkedList<Integer[]> catList = null;
    LinkedList<Integer[]> dogList = null;

    public AnimalShelf() {
        anyList = new LinkedList<>();
        catList = new LinkedList<>();
        dogList = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        Integer[] integers = {animal[0], animal[1]};
        if (animal[1] == 0)
            catList.offer(integers);
        else if (animal[1] == 1)
            dogList.offer(integers);
        anyList.offer(integers);
    }

    public int[] dequeueAny() {
        Integer[] animal = anyList.poll();
        if (animal[1] == 0)
            catList.poll();
        if (animal[1] == 1)
            dogList.poll();
        int[] res = {animal[0], animal[1]};
        return res;
    }

   /* -- 取出dog队列中的元素，还要将 any中对应的元素移除，显然是过于复杂的。
   public int[] dequeueDog() {
        Integer[] dog = dogList.poll();
        int[] res = {dog[0], dog[1]};
        Integer[] animal = anyList.poll();
        if (animal[1] == 0)

        return res;

    }

    public int[] dequeueCat() {

    }*/
}