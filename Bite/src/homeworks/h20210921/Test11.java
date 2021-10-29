package homeworks.h20210921;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

public class Test11 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        /*linkedList.addAtHead(1);
        System.out.println(123);
        linkedList.addAtTail(3);
        System.out.println(123);

        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(123);

        System.out.println(linkedList.get(1));
        System.out.println(123);

        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(123);

        System.out.println(linkedList.get(1));
        System.out.println(123);*/
        linkedList.addAtHead(7);
        linkedList.addAtTail(7);

        linkedList.addAtHead(9);
        linkedList.addAtTail(8);

        linkedList.addAtHead(6);
        linkedList.addAtHead(0);

        System.out.println(linkedList.get(5));

        linkedList.addAtHead(0);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(5));
        linkedList.addAtTail(4);

    }
}

class LinkedNode {
    int val;
    LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    LinkedNode head = null;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        LinkedNode temp = head;
        while (temp != null) {
            if (index == 0)
                return temp.val;
            else
                index--;
            temp = temp.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null)
            head = new LinkedNode(val);
        else {
            LinkedNode linkedNode = new LinkedNode(val);
            linkedNode.next = head;
            head = linkedNode;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        LinkedNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new LinkedNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        LinkedNode temp = head;
        index--;
        while (temp != null) {
            if (index == 0) {
                LinkedNode linkedNode = new LinkedNode(val);
                linkedNode.next = temp.next;
                temp.next = linkedNode;
                return;
            }
            else
                index--;
            temp = temp.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null)
            return;
        if (index == 0) {
            if (head.next != null)
                head = head.next;
            else
                head = null;
            return;
        }
        LinkedNode helper = head;
        LinkedNode temp = helper.next;
        index--;
        while (temp != null) {
            if (index == 0) {
                helper.next = temp.next;
                return;
            }
            else
                index--;
            helper = helper.next;
            temp = helper.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */