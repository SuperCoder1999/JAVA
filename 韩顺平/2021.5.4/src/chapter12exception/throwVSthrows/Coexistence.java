package chapter12exception.throwVSthrows;

/**
 * 既有 throws 也有 throw时，抛出的是throw的。
 */

public class Coexistence {

    public static int aMethod(int i) throws Exception {

        try {
            return 10 / i;
        } catch (Exception ex) {
            System.out.println("exception in a aMethod");//1
            throw new Exception("exception in a aMethod");
        } finally {
            System.out.println("finally");//2
        }
    }

    public static void main(String[] args) {
        try {
            aMethod(0);
            //aMethod2(0);//这个getMessage()的内容是 / by zero。即throws Exception的内容
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//3
            System.out.println("exception in main");//4
        }
        System.out.println("finished");//5
    }


    public static int aMethod2(int i) throws Exception {

        return 10 / i;
        
    }
}