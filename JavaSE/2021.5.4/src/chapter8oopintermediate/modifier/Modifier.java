package chapter8oopintermediate.modifier;

public class Modifier {
    public static void main(String[] args) {
        /*
        1. 公开级别：用public 修饰，对外公开
        2. 受保护级别：用protected 修饰，对子类和同一个包中的类公开
        3. 默认级别：没有修饰符，对同一个包的类公开（同包下的子类应该也可以）
        4. 私有级别：用private 修饰，只有类本身可以访问，不对外公开

        public      本类  同包  子类  不同包
        protected   本类  同包  子类
        默认         本类  同包
        private     本类

        二：注意
        1. 修饰符可以修饰类中的属性、成员方法以及类
        2. 修饰类时，只能使用 默认 和 public，且访问权限和上面一样

         */
    }
}
