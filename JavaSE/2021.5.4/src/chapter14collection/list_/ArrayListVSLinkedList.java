package chapter14collection.list_;

/*
    一：LinkedList、ArrayList不是线程安全，Vector是线程安全
    二：ArrayList VS LinkedList
                底层结构     增删的效率      查改的效率
    ArrayList   可变数组    较低(数组扩容)    较高
    LinkedList  双向链表    较高(链表追加)    较低

    三：LinkedList、ArrayList 和 Vector 的选择
    1. 如果查改的操作多 ： ArrayList
    2. 如果增删的操作多 ： LinkedList
    3. 双线程         ： Vector
    4. 一般，业务中80~90%都是查询，所以大部分情况下 ArrayList
    5. 在一个项目中，灵活选择，可以在一个模块中使用ArrayList，一个模块使用LinkedList。根据业务进行选择
 */

public class ArrayListVSLinkedList {
}
