package Classroom.c20210928;

public class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
