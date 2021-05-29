package chapter7oopprimary.ChapterHomeworks;

/*
    编写类A03, 实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 */
public class Homework04 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 76, 44, -9};
        A03 aA03 = new A03();
        int[] newArr = aA03.copyArr(arr);
        for (int i : newArr)
            System.out.print(i + " ");
    }
}

class A03 {

    public int[] copyArr(int[] oldArr) {
        int[] newArr = new int[oldArr.length];
        int j= 0;
        for (int i : oldArr) {
            newArr[j++] = i;
        }
        return newArr;
    }
}