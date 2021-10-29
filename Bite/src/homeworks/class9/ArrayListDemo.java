package homeworks.class9;

/*
作业标题
实现顺序表代码

作业内容
实现顺序表代码
 */

public class ArrayListDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(5);
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.display();
        myArrayList.remove(2);
        //myArrayList.clear();
        System.out.println("===========");
        myArrayList.display();

        System.out.println(myArrayList.contains(14));
        System.out.println(myArrayList.search(-10));
        try {
            System.out.println(myArrayList.getPos(10));
        } catch (Exception e) {
            System.out.println(e);;
        }
        System.out.println(myArrayList.size());

        myArrayList.setPos(2,6);
        myArrayList.display();
    }
}

class MyArrayList {
    private int capacity;//顺序表的容量
    private int[] array;
    private int usedSize = 0;
    //这里赋值0是因为这个变量表示数组被用了多少。和顺序表尾部的位置有些区别。
    // 其实是指向最后一个元素后面一个位置

    //构造器，确定容量，创建数组
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public boolean isFull() {
        return usedSize == capacity;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 在 pos 位置新增元素.顺序表所有的元素必须是连续的。
    public void add(int pos, int data) {
        //pos小于0的情况就不考虑了
        if (pos > usedSize) {//usedSize指向的是表尾的最后一个
            System.out.println("该位置将导致顺序表断开");
            return;
        }
        if (isFull()) {
            System.out.println("顺序表已经满了");
            return;
        }
        for (int i = usedSize - 1; i >= pos; i--) {//实际上usedSize这个位置上暂时没有放元素
            array[i + 1] = array[i];
        }
        array[pos] = data;
        usedSize++;
    }

    // 打印顺序表
    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空,无元素需要打印");
            return;
        }
        for (int i = 0; i < usedSize; i++) {
            System.out.println(array[i]);
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (array[i] == toFind)
                return true;
        }
        return false;//遍历完，还没有找到就说明没有
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (array[i] == toFind)
                return i;
        }
        return -1;//没有找到返回-1
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos >= usedSize) {
            throw new RuntimeException("该位置没有元素");
        }
        return array[pos];
    }

    //获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos >= usedSize) {
            System.out.println("该位置没有元素");
            return;
        }
        array[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int pos = -1;//既能存放位置下标，还能判断是否找到
        for (int i = 0; i < usedSize; i++) {
            if (array[i] == toRemove) {
                pos = i;
                break;
            }
        }
        if (pos == -1)
            System.out.println("没找到");
        else {
            for (int i = pos; i < usedSize - 1; i++) {
                //因为一次移动两个。所以最后一个要-1，防止越界
                array[i] = array[i + 1];
            }//其实质是usedSize-1位置的内容还在。
            usedSize--;//将用的长度-1
        }
    }

    // 清空顺序表
    public void clear() {
        usedSize = 0;//本质其他元素还在。可以不用将所有的元素都赋0
    }
}