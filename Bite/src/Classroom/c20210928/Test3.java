package Classroom.c20210928;

/**
 * 求叶子节点个数 遍历思路 子问题思路
 */

public class Test3 {
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
        //遍历思路
        //System.out.println(getLeafSize(A));
        //子问题思路
        System.out.println(new Test3_1().getLeafSize(A));
    }

    //遍历思路
    static int size = 0;
    public static int getLeafSize(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                size++;
            }
            getLeafSize(root.left);
            getLeafSize(root.right);
        }
        return size;
    }
}

class Test3_1 {
    //子问题思路
    public int getLeafSize(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    
}