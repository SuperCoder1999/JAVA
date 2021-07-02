package chapter11enum_annotation.enum_.keywordenum;
/*
    一：Enum中的方法
    1. toString：Enum类已经重写过了，返回的是当前对象名，
        子类（定义的enum枚举类）可以重写该方法，用于返回对象的属性
    2. name：返回当前对象名（常量名），子类中不能重写
    3. ordinal：返回当前对象的位置号，默认从0开始
    4. values：返回一个数组：包含当前枚举类中所有的常量
    5. valueOf：将字符串转换成枚举对象，要求字符串必须是已有的常量名，否则报异常
    6. compareTo：比较两个枚举常量，比较的是位置号
        （返回本枚举常量序号减括号内的枚举常量序号 得来的数字）
 */
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season2 枚举类，来演示各种方法
        Season2 autumn = Season2.AUTUMN;

        // 2.name：返回当前枚举对象名（常量名），子类中不能重写
        System.out.println(autumn.name());

        // 3.ordinal() 输出的是该枚举对象的次序/编号，从0开始编号
        //AUTUMN 枚举对象是第三个，因此输出 2
        System.out.println(autumn.ordinal());

        // 4.values：返回一个数组：包含当前枚举类中所有的常量
        //从反编译可以看出 values方法，返回 Season2[]
        //含有定义的所有枚举对象
        Season2[] values = Season2.values();// 得从反编译中查看
        System.out.println("===遍历取出枚举对象(增强for)====");
        for (Season2 season: values) {//增强for循环
            System.out.println(season);
        }

        // 5.valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        //执行流程
        //1. 根据你输入的 "AUTUMN" 到 Season2的枚举对象去查找
        //2. 如果找到了，就返回，如果没有找到，就报错
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1=" + autumn1);
        System.out.println(autumn == autumn1);

        // 6.compareTo：比较两个枚举常量，比较的就是编号
        //老韩解读
        //1. 就是把 Season2.AUTUMN 枚举对象的编号 和 Season2.SUMMER枚举对象的编号比较
        //2. 看看结果
        /*
        public final int compareTo(E o) {

            return self.ordinal - other.ordinal;
        }
        Season2.AUTUMN的编号[2] - Season2.SUMMER的编号[3]
         */
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));

        //补充了一个增强for
//        int[] nums = {1, 2, 9};
//        //普通的for循环
//        System_.out.println("=====普通的for=====");
//        for (int i = 0; i < nums.length; i++) {
//            System_.out.println(nums[i]);
//        }
//        System_.out.println("=====增强的for=====");
//        //执行流程是 依次从nums数组中取出数据，赋给i, 如果取出完毕，则退出for
//        for(int i : nums) {
//            System_.out.println("i=" + i);
//        }
    }
}
