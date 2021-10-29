package homeworks.h20210928;

import java.util.LinkedList;
import java.util.Stack;

public class Test1 {
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
        //前序遍历
        new BinaryTree(A).preOrder();
        //中序遍历
        System.out.println("中序遍历");
        new BinaryTree(A).infixOrder();

        //后序遍历
        System.out.println("后序遍历");
        new BinaryTree(A).pastOrder();

        //层序遍历
        System.out.println("层序遍历");
        new BinaryTree(A).layerOrder();
    }
}

class BinaryTree {
    Node root = null;

    public BinaryTree(Node root) {
        this.root = root;
    }

    //非递归 前序遍历
    /*
    1.借用栈完成非递归遍历。
    2.栈中先放入root节点。根据前序遍历的顺序，先输出栈顶节点。然后将非空的右子树根节点和左子树根节点入栈
     */
    public void preOrder() {

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur);
            //先右后左
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    //非递归 中序遍历
    /*
     */
    public void infixOrder() {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {//还能继续向左遍历，就尝试向左遍历
                stack.push(cur);
                cur = cur.left;
            } else {
                Node pop = stack.pop();
                System.out.println(pop);
                cur = pop.right;
            }
        }
    }

    //非递归 后序遍历
    public void pastOrder() {
        Stack<Node> stack = new Stack<>();
        Stack<Node> printStack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            printStack.push(cur);

            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
        while (!printStack.isEmpty()) {
            System.out.println(printStack.pop());
        }
    }

    //非递归 层遍历
    public void layerOrder() {
        /*
        1.和非递归前序遍历不同的是，前序是在取出栈顶元素时打印。而层序可以在入队或出队时打印
         */
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);
        System.out.println(root);
        while (!list.isEmpty()) {
            //如果是完全二叉树，每出一个队头元素就会入队2个元素。但也不用担心会出现死循环之类的情况
            //因为，循环中一直都会stack.poll();而不进入if中。poll()会不断消耗栈内的元素
            Node stackPeek = list.poll();
            //因为是在入队时输出，所以先入左子树
            if (stackPeek.left != null) {
                System.out.println(stackPeek.left);
                list.offer(stackPeek.left);
            }
            if (stackPeek.right != null) {
                System.out.println(stackPeek.right);
                list.offer(stackPeek.right);
            }
        }
    }

}

