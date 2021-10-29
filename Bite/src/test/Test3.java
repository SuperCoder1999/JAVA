package test;

/*
    1.temp = head.next;则改变temp 会改变head.next吗。
    答案：不会改变，原理：temp指向一个对象-head.next，之后temp有改变了指向
 */

public class Test3 {
    public static void main(String[] args) {


        Node head = new Node(1);
        Node temp = head.next;
        Node node = new Node(2);
        temp = new Node(6);

        Node head2 = new Node(3);
        Node temp2 = head2;
        Node node2 = new Node(4);
        temp2.next = node2;

        System.out.println(head.next);
        System.out.println(head2.next);
    }
}
class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}