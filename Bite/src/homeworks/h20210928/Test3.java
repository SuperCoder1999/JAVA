package homeworks.h20210928;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

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

        BinaryTree2 b = new BinaryTree2(A);

        //先序遍历
        System.out.println("先序遍历");
        System.out.println(b.preOderTraversal(A));

        //中序遍历
        System.out.println("中序遍历");
        System.out.println(b.infixOrderTraversal(A));

        //后序遍历
        System.out.println("后序遍历");
        System.out.println(b.pastOrderTraversal(A));


        //求节点个数
        System.out.println("求节点个数");
        System.out.println(b.getNodes(A));

        //求叶子节点的个数
        System.out.println("求叶子节点的个数");
        System.out.println(new BinaryTree2(A).getLeafNodes(A));

        //求第K层节点个数
        System.out.println("求第K层节点个数");
        System.out.println(new BinaryTree2(A).getKNodes(A, 3));

        //查找节点
        System.out.println("查找节点");
        System.out.println(new BinaryTree2(A).searcherNode(A, 'E'));
    }
}

class BinaryTree2 {
    public Node root = null;

    public BinaryTree2(Node root) {
        this.root = root;
    }

    //先序遍历
    public List<Character> preOderTraversal(Node root) {
        List<Character> resList = new ArrayList<>();

        if (root == null)
            return resList;//错误点

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            resList.add(cur.val);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return resList;
    }

    //中序遍历二叉树
    public List<Character> infixOrderTraversal(Node root) {
        ArrayList<Character> resList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                Node stackPeek = stack.pop();
                resList.add(stackPeek.val);
                cur = stackPeek.right;
            }
        }
        return resList;
    }

    //后序遍历二叉树
    public List<Character> pastOrderTraversal(Node root) {
        ArrayList<Character> resList = new ArrayList<>();

        if (root == null)
            return resList;//和前序遍历一样，需要考虑root==null的情况

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node stackPeek = stack.pop();
            resList.add(stackPeek.val);
            if (stackPeek.left != null)
                stack.push(stackPeek.left);
            if (stackPeek.right != null)
                stack.push(stackPeek.right);
        }
        //逆转resList
        int left = 0;
        int right = resList.size() - 1;
        /* - 这里 resList.get得到的是新的Character对象。
        while (left < right) {
            swap(resList.get(left), resList.get(right));
            left++;
            right--;
        }*/
        while (left < right) {
            swap(resList, left, right);
            left++;
            right--;
        }
        return resList;
    }
    public void swap(List<Character> list, int left, int right) {
        Character temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    //求节点个数
    public int getNodes(Node root) {
        //采用子问题求解的方式
        int resNum = 0;
        if (root == null)
            return 0;
        int leftNodes = getNodes(root.left);
        int rightNodes = getNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    //求 叶子节点 个数
    public int getLeafNodes(Node root) {
        //子问题求解
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftLeafNodes = getLeafNodes(root.left);
        int rightLeafNodes = getLeafNodes(root.right);
        //这里和 求节点个数不同，因为不是每个节点算数而+1;
        // 算数的节点一定在leftLeafNodes 和 rightLeafNodes中
        return leftLeafNodes + rightLeafNodes;
    }

    //求第k层节点的个数
    public int getKNodes(Node root, int k) {
        //采用子问题求解，关注k是否=1
        if (root == null)
            return 0;
        if (k == 1)
            return 1;
        int leftKNodes = getKNodes(root.left, k - 1);
        int rightKNodes = getKNodes(root.right, k - 1);
        //和 求叶子节点个数一样。
        // 算数的节点，要么是当前的节点(此时返回1即可),要么是在leftKNodes和rightKNodes中
        return leftKNodes + rightKNodes;
    }

    //查找节点
    public Node searcherNode(Node root, Character find) {
        //前序遍历的同时寻找
        Node resNode = null;
        if (root == null)
            return resNode;
        if (root.val == find)
            return root;
        //遍历查找左子树
        resNode = searcherNode(root.left, find);
        //一旦左子树搜索到，就返回。防止resNode被右子树结果影响
        if (resNode != null)
            return resNode;
        resNode = searcherNode(root.right, find);
        return resNode;
    }
}