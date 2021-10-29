package homeworks.h20210928;

public class Test2 {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
