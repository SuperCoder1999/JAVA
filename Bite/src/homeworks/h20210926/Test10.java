package homeworks.h20210926;

public class Test10 {
    public static void main(String[] args) {
    }

//    public static int getResult(int n) {
//        // write code here
//        /*
//        1.对数组进行操作。每次都需要遍历n次。链表的话，每次都会减少遍历次数。
//        2.采用链表的方式，创建节点类，val存储下标。根据n创建链表。
//        3.因为返回的是其中一个节点的下标，和头节点无关。只需要两个指针-helper\curNode
//        4.curNode指向遍历的位置，helper指向前一个节点便于删除节点
//        5.while循环，每次数的数字增加1.直到helper==null
//         */
//        class Node {
//            int val;
//            Node next;
//            public Node(int val) {
//                this.val = val;
//            }
//
//            @Override
//            public String toString() {
//                return "Node{" +
//                        "val=" + val +
//                        '}';
//            }
//        }
//
//        Node head = new Node(1);
//        Node temp = head;
//        for (int i = 2; i <= n; i++) {
//            Node node = new Node(i);
//            temp.next = node;
//            temp = temp.next;
//        }
//        temp.next = head;
//        //完成环形链表的创建。
//        /*//遍历
//        Node curNode = head;
//        while (true) {
//            System.out.println(curNode);
//            curNode = curNode.next;
//            if (curNode == head)
//                break;
//        }*/
//
//
//    }
}
