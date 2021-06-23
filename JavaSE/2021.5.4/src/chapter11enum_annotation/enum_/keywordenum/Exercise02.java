package chapter11enum_annotation.enum_.keywordenum;

/*
    一：枚举类中的toString方法
    由于enum创建枚举常量的本质是继承Enum类，所以toString方法是Enum的同String方法

    Enum中的toString方法代码：（事实上，从反编译中还看到了toString方法，所以这个还是不清楚）
        public String toString() {
        return name;
    }
    返回的是枚举常量的对象名

 */
public class Exercise02 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;
        Gender2 boy2 = Gender2.BOY;
        System.out.println(boy);// 按照toString方法来看，其中
        System.out.println(boy2 == boy);
    }
}

enum Gender2 {
    BOY,GIRL;
}
