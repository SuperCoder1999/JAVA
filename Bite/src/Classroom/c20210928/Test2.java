package Classroom.c20210928;

/**
 * 求二叉树节点个数，遍历思想 与 子问题思想
 */
public class Test2 {
    public static void main(String[] args) {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        //遍历的方式统计节点个数
        System.out.println("遍历的方式统计节点个数" + nodeSize(A));

        //求解子问题的方式统计节点个数
        Test2_1 test2_1 = new Test2_1();
        System.out.println(test2_1.nodeSize(A));
    }

    //遍历的方式
    static int size = 0;

    public static int nodeSize(Node root) {
        if (root != null) {
            size++;
            nodeSize(root.left);
            nodeSize(root.right);
        }
        return size;
    }
}


class Test2_1 {
    //遍历的方式统计节点个数
    public int nodeSize(Node root) {
        int size = 0;
        if (root != null) {
            size++;
            int leftSize = nodeSize(root.left);
            size += leftSize;
            int rightSize = nodeSize(root.right);
            size += rightSize;
        }
        return size;
        /*
        简洁代码：
        if (root == null) {
            return 0;
        }
        return nodeSize(root.left) + nodeSize(root.right) + 1;
         */
    }
}


