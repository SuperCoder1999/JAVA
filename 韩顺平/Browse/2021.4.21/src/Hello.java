public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello,idea");
        T t = new T();
    }
}

/**
 * 构造器调用其他构造器，最多只能调用一个。
 * 不能直接用其方法名调用。只能通过 this
 */
class T{
    public T(){
        this("nie",20);
        System.out.println("无参构造器");
    }
    public T(String name,int age){
        this(200);
        System.out.println("无参构造器调用其他构造器");
    }
    public T(int money){
        System.out.println("100w");
    }
}
