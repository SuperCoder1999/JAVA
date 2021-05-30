package chapter8oopintermediate.encapsulation;

public class EncapIntroduction {
    public static void main(String[] args) {
        /*
        一：封装的概念
            封装就是把抽象出来的数据（属性）和对数据的操作（方法）封装在一起
        数据被保护在内部，程序的其他部分只能通过被授权的操作（方法）对数据进行操作

        二：封装的好处
            1）隐藏实现细节：不用关心方法时怎么实现的，只需要调用即可
            2）可以对数据进行检验，保证安全合理

        三：封装的步骤
        1.将属性进行私有化private - 使不能直接修改属性
        2.提供一个公共的（public）set方法，用于对属性的判断并赋值
            public void setXxx(类型 参数名) {
                // 加入数据验证的业务逻辑（如判断要修改的年龄是否合理）
                属性 = 参数名;
            }
        3.提供一个公共的（public）get方法，用于获取属性的值
         public 数据类型 getXxx() {
            // 判断是否有权限获取
            return xx;
        }

         */


    }
}
