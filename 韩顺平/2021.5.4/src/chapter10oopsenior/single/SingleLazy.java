package chapter10oopsenior.single;

/*
    一：懒汉式定义：
    懒汉式就是说：只有调用getInstance时才进行创建对象
    懶漢式，只有當用戶使用getInstance時，才返回cat對象, 後面再次調用時，會返回上次創建的cat對象

    二：步驟
    1.将構造器私有化
    2.定義一個static靜態屬性對象
    3.提供一個public的static方法，可以返回一個Cat對象
    4.懶漢式，只有當用戶使用getInstance時，才返回cat對象, 後面再次調用時，會返回上次創建的cat對象
  從而保證了單例

     三：缺点
     懒汉式存在线程安全的问题【当多个线程同时巡行到if语句时可能发生】

     四：两者区别：
       创建对象的时机不同
 */

public class SingleLazy {
    public static void main(String[] args) {
        System.out.println(Friend.n1);
        System.out.println(Friend.getInstance());
         // 懒汉式就是说：只有调用getInstance时才进行创建对象
    }
}

class Friend {
    private String name;

    public static int n1 = 100;

    private static Friend friend;
    private Friend(String name) {
        this.name = name;
    }

    public static Friend getInstance() {
        if (friend == null) {
            friend = new Friend("小王");
            return friend;
        }
        else
            return friend;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }
}
