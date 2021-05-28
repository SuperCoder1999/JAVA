package chapter7_ObjectOrientedProgramming.Constructor;

/*
    在前面定义的Person类中添加两个构造器:
     第一个无参构造器：利用构造器设置所有人的age属性初始值都为18
     第二个带pName和pAge两个参数的构造器：
     使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
     分别使用不同的构造器，创建对象.
 */
public class ConstructorExercise {
    public static void main(String[] args) {

        ExercisePerson aExercisePerson = new ExercisePerson();// name的输出是 null
        ExercisePerson bExercisePerson = new ExercisePerson("Jack",20);
        ExercisePerson cExercisePerson = new ExercisePerson("Tom",19);
        // 查看输出结果
        System.out.println(aExercisePerson.name + " " + aExercisePerson.age);
        System.out.println(bExercisePerson.name + " " + bExercisePerson.age);
        System.out.println(cExercisePerson.name + " " + cExercisePerson.age);

    }
}

class ExercisePerson {

    String name;
    int age;

    // 第一个无参构造器：利用构造器设置所有人的age属性初始值都为18
    public ExercisePerson() {
        age = 18;
    }

    //第二个带pName和pAge两个参数的构造器：
    //使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
    public ExercisePerson(String eName, int eAge) {
        name = eName;
        age = eAge;
    }

}