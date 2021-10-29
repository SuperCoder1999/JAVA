package Classroom.c20210928;

/**
 * 获取二叉树的高度
 * 备注：老师的方法有些抽象，先记下来，慢慢体会
 */

public class Test5 {
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
        //自己的方法，定义成员变量layer 递归前后分别 + -
        getHeight(A);
        System.out.println(max);

        //韩顺平老师和比特方法
        System.out.println(getHeight2(A));

        //分析超时代码的原因
        System.out.println(getHeight3(A));
    }

    //尝试我自己的layer递归前后+-变化.
    static int layer = 0;
    static int max = 0;
    public static void getHeight(Node root) {
        //进入了下一层，所以 layer++
        layer++;
        if (root == null) {
            //这一层无效，layer加的那个1 再 去掉
            layer--;
            return;
        }
        //这一层有效，记录当前层数
        if (max < layer)
            max = layer;
        getHeight(root.left);
        getHeight(root.right);
        //现在返回上一层了。
        layer--;
    }

    //韩顺平老师和比特方法 - 这两种是一种方式，只是写的不一样。
    public static int getHeight2(Node root) {
        if (root == null)
            return 0;
        //先将当前这一层统计下来+1.
        return 1 + Math.max(getHeight2(root.left), getHeight2(root.right));
        /*
        大体递归步骤
        1.虽然我一开始就求root的left高度。但是再求root.left高度时，又往下遍历。
        整体的求解顺序是：从下向上，对于每一层，从左到右依次求得每个节点作为根的二叉树的高度
         */
    }

    //超时的代码，分析下为什么超时。我认为这个的时间复杂度只有 4n
    public static int getHeight3(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight3(root.left);
        int rightHeight = getHeight3(root.right);
        return getHeight3(root.left) > getHeight3(root.right) ? getHeight3(root.left) + 1 : getHeight3(root.right) + 1;
    }
}
