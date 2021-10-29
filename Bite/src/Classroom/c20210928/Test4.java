package Classroom.c20210928;

/**
 * 第K层的节点个数
 */
public class Test4 {
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
        //统计第K层节点个数
        System.out.println(getKSize(A, 3));

        //利用helper方法 来统计
        System.out.println(getKSize2(A, 3));

        //将 k 当作计数器 来统计
        System.out.println(getKSize3(A, 3));
    }

    static int layer = 0;

    /**
     * 第K层的节点个数
     * 1.自己思考的方法
     */
    public static int getKSize(Node root, int k) {
        layer++;
        if (root == null) {
            layer--;
            return 0;
        }
        if (layer == k) {
            layer--;
            return 1;
        }
        int count1 = getKSize(root.left, k);

        int count2 = getKSize(root.right, k);
        layer--;
        return count1 + count2;
    }

    /**
     * 2.通过老师的方法，改进自己的方法
     * 因为难点在于得知当前的层数。如果层数在外部定义，则向下递归时+1，返回时需要-1.
     * 如果每次递归都提示当前层数就很方便。
     */
    public static int getKSize2(Node root, int k) {
        return getKSizeHelper(root, k, 1);
    }

    public static int getKSizeHelper(Node root, int k, int layer) {
        if (root == null)
            return 0;
        if (layer == k)
            return 1;
        return getKSizeHelper(root.left, k, layer + 1) +
                getKSizeHelper(root.right, k, layer + 1);
    }

    /**
     * 3.老师的方法
     * 将 K 当作根节点所在层的序号，子节点所在层数一次减少。此时 k 就变成一个记录层数的变量。
     * 当 k=1 时，表示递归到所要计算的那一层。
     */
    public static int getKSize3(Node root, int k) {
        if (root == null)
            return 0;
        if (k == 1)
            return 1;
        return getKSize3(root.left, k - 1) +
                getKSize3(root.right, k - 1);
    }
}
