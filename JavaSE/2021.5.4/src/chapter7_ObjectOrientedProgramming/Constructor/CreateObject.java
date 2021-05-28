package chapter7_ObjectOrientedProgramming.Constructor;

public class CreateObject {

    CreateObjectPerson p = new CreateObjectPerson("小倩", 20);
    /*
    1. 方法区：加载CreateObjectPerson类信息（CreateObjectPerson.class)，只会加载一次
    2. 堆：
        1）开辟空间（地址：0x1122）用于存放age和name，开辟的空间是默认初始化
        （age：0，name：null）；
        2）再进行显式初始化，age更改为90。因为name没有显式初始化，所以不变
        3）最后执行构造器，进行构造器初始化。
            a. 方法区-常量池：小倩（0x1133） 小倩的地址传给pName
            b. 堆中：pName的地址赋给name、pAge赋给age
    3. 栈的main栈/main方法：将堆中开辟的空间地址（0x1122）赋给对象名 p（对象引用）

    简化：
    1.加载类的信息
    2.分配堆中的空间
    3.完成对象初始化（三个步骤：默认初始化，显式初始化，构造器初始化）
    4.把对象在堆中的地址赋值给对象名（对象的引用）
     */
}

class CreateObjectPerson {
    int age = 90;
    String name;
    CreateObjectPerson(String cName, int cAge) {
        name = cName;
        age = cAge;
    }
}