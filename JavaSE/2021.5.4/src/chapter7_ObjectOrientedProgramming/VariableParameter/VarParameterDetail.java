package chapter7_ObjectOrientedProgramming.VariableParameter;

public class VarParameterDetail {
    public static void main(String[] args) {

        // 1. 可变参数的实参可以是 0个或任意多个
        // 2. 可变参数的实参可以是数组
        // 3. 可变参数的本质是数组
        // 4. 可变参数看可以和普通类型的参数一起放在参数列表中，但可变参数必须在最后
        // 5. 一个形参列表最多出现一个可变参数

        //细节 2 ：可变参数的实参可以是数组
        double[] arr = {1.1, 1.2, 1.3 ,1.0};
        VarParameter aVarParameter = new VarParameter();
        System.out.println("实参为数组：" + aVarParameter.sum(arr));

        //细节4
        aVarParameter.detail04("笨蛋  ", 1, 2, 3);
    }
}

class VarParameter {
    public double sum(double... nums) {
        double res = 0;
        for (double i : nums) {
            res += i;
        }
        return res;
    }

    //细节4. 可变参数看可以和普通类型的参数一起放在参数列表中，但可变参数必须在最后
    public void detail04(String str, double... nums) {
        System.out.println("可变参数与普通参数同用：" + str + nums.length);
    }
        // 可以将可变数组中的前几个 单独领出来放在参数列表中
    public double detail04_1(double d1, double... nums) {
        double res = d1;
        for (double i : nums) {
            res += i;
        }
        return res;
    }


}
