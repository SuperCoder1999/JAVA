package Classroom.c20210928;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历二叉树 引出的 子问题解决方法
 */

public class Test1 {

    //方法一：在方法外创建一个list，此时解决的方法是遍历的方式

    public List<Character> preorderTraversal(Node root) {

        //此第二种方法采用的是子问题解决方法
        List<Character> list = new ArrayList<>();

        if (root != null) {

            list.add(root.val);

            //将左子树所有节点保存下来
            List<Character> leftList = preorderTraversal(root.left);
            list.addAll(leftList);

            //将右子树所有节点保存下来
            List<Character> rightList = preorderTraversal(root.right);
            list.addAll(rightList);


        }
        return list;
        //方法三：也可以在preorderTraversal() 方法内创建list。传入另一个真正实现遍历的方法进行统计。
        //该方法也是 利用遍历的思想
    }
}