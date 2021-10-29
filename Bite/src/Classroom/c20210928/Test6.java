package Classroom.c20210928;

/**
 * 查找节点 - 重点：在子树中找到后立刻返回，不能再进入左子树遍历
 */

public class Test6 {
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
        System.out.println(find(A, 'E'));
    }

    //前序遍历的步骤 搜索节点
    public static Node find(Node root, char val) {
        Node res = null;
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        res = find(root.left, val);
        /*
        这里，如果在左子树找到了，还会进入右子树。就会将res改变。所以需要在遍历一边后判断是否
        找到。找到就返回，不再遍历右子树
         */
        if (res != null) {
            return res;
        }
        res = find(root.right, val);
        return res;
    }

}
