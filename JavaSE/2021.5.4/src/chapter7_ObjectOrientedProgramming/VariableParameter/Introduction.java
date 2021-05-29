package chapter7objectorientedprogrammingprimary.VariableParameter;

public class Introduction {
    public static void main(String[] args) {
        /*
            当需要计算 2个、3个、4个……int 的和时，可以使用方法重载 如方法 sum
            不过 最好使用可变参数优化
             */
        VariableParameter aVariableParameter = new VariableParameter();
        System.out.println(aVariableParameter.sum());
        System.out.println(aVariableParameter.sum(1,2,3,5,6));
    }
}

class VariableParameter {
    /*
        public int sum(int n1, int n2) {

            return n1 + n2;
        }
        public int sum(int n1, int n2, int n3) {
            return n1 + n2 + n3;
        }
        */
    //……
    // 上面方法 方法名相同、功能相同、参数类型相同、参数个数不同 -> 使用可变参数优化

    /*
        可变参数：
            1. int... 表示接受的可变参数，类型是int，可以接收多个int（0-n）
            2. 使用可变参数时，可以当作数组来操作  即nums 作为数组遍历
            3. 此方法中，遍历nums求和即可
         */
    public int sum(int... nums) {
        System.out.println(nums.length);// 长度为0 的数组也能进行计算
        int res = 0;
        for(int i : nums) {
            res += i;
        }
        return res;
    }
}
