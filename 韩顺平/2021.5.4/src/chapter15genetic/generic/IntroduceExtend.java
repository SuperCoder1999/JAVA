package chapter15genetic.generic;
import java.util.List;

/*
    举例讲解第五点：
    5. 泛型的作用：可以在类声明时通过一个标识<E>表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
 */

public class IntroduceExtend {
    public static void main(String[] args) {

        //注意，特别强调： E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
        // 再传入其他类型的数据就会报错。
        // 可以通过getClass() 来获得 属性、方法的类型
        Person<String> person = new Person<String>("韩顺平教育");
        person.show(); //String

        /*
            原本的Person类就变成了如下：
            class Person {
                String s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(String s) {//E也可以是参数类型
                    this.s = s;
                }

                public String f() {//返回类型使用E
                    return s;
                }
            }
         */

        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();//Integer
        //System.out.println(person2.getClass()); 类的类型就是类本身

        /*
            原本的Person类就变成了如下：
            class Person {
                Integer s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(Integer s) {//E也可以是参数类型
                    this.s = s;
                }

                public Integer f() {//返回类型使用E
                    return s;
                }
            }
         */
    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型

class Person<E> {// 这里E不能省略
    E s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }

    public void f(E c) { // 这里传入的参数类型是泛型
        E a;// 局部变量 被定义为 E泛型
    }

    public E f2() { //返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
        System.out.println(f2().getClass());
    }
}