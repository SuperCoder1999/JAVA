package chapter7oopprimary.transfer_parameters;

/**
 * 引用类型 传参
 *
 * 1.String类型 在被传递者中，引用变量就不是“字符串本体”，而是字符串的引用。对这个引用的操作就是操作原来的引用。
 * 2.char数组等引用类型的引用变量，才是指向数据本体。对引用的操作就是操作数据本体
 * 3.看7.3.2图示，比较清晰
 */
public class ReferenceType {
        String str=new String("tarena");
        char[] ch={'a','b','c'};

        public static void main(String[] args){
            ReferenceType ex=new ReferenceType();
            ex.change(ex.str,ex.ch);
            System.out.print(ex.str+" and ");
            System.out.print(ex.ch);
        }

        //String的引用变量传参：复制了一份地址给形参
        public void change(String str,char[] ch) {
            //引用类型变量，传递的是地址，属于引用传递。
            str = "test ok";
            ch[0] = 'g';
        }
}
