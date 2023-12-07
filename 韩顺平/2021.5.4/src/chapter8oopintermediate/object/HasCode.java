package chapter8oopintermediate.object;
/*
    1. hashCode能提高具有哈希结构的容器的效率
    2. 两个引用（这里和对象区别开），如果指向的是同一个对象，则哈希值肯定是一样的
    3. 两个引用，如果指向的是不同对象，则哈希值是不一样的
    4. 哈希值主要是根据地址号来的，不能完全将哈希值等价于地址
    5. 后面在集合章节中，hashCode可能要重写
 */
public class HasCode {
    public static void main(String[] args) {
        AA aa1 = new AA();
        AA aa2 = new AA();
        AA aa3 = aa1;
        System.out.println("aa1 = " + aa1.hashCode());
        System.out.println("aa2 = " + aa2.hashCode());
        System.out.println("aa3 = " + aa3.hashCode());
    }
}

class AA {

}