package chapter8oopintermediate.poly.polyarr;

public class PolyArr {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        // 动态数组用到了向上转型
        person[0] = new Students("大壮", 18, 100);
        person[1] = new Students("小白", 10, 99);
        person[2] = new Teacher("老王", 40, 2500);

        for (Person i : person) {
            System.out.println(i.say());
            // 这里都是向下转型
//            if (i instanceof Person)// 判断的是是不是Person类或Person类的子类
//            {
//                System.out.println("没有运行之后的");
//            }
//            else
            if (i instanceof Students) {// 这里判断的是运行类型
                Students student = (Students)i;
                student.stay();
            }
            else if (i instanceof Teacher) {
                Teacher teacher = (Teacher)i;
                teacher.teacher();
            }
        }
    }
}
