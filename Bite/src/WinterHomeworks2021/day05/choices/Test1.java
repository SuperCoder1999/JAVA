package WinterHomeworks2021.day05.choices;

public class Test1 {
        public static void main(String[] args){
            Integer var1=new Integer(1);
            Integer var2=var1;
            doSomething(var2);
            System.out.println(var1.intValue());//1
            System.out.println(var2);//1
            System.out.print(var1==var2);//true
        }
        public static void doSomething(Integer integer) {
            integer = new Integer(2);
        }
}