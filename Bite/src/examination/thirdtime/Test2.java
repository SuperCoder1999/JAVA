package examination.thirdtime;

/*public class Test2 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = list1.val < list2.val ? list1 : list2;
        ListNode temp = head;
        ListNode temp1 = list1.next;
        ListNode temp2 = list2.next;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else
            temp.next = temp2;
        return head;
    }
}*/
public class Test2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(8);
        ListNode list1 = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode list2 = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode head = Merge(list1, list2);
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp1 = null;
        ListNode temp2 = null;
        if (list1 == null && list2 == null) {
            return head;
        }
        if (list1 == null || list2 == null) {
            return head = list1 == null ? list2 : list1;
        }
        if (list1.val <= list2.val) {
            head = list1;
            temp1 = list1.next;
            temp2 = list2;
        } else {
            head = list2;
            temp2 = list2.next;
            temp1 = list1;
        }
        ListNode temp = head;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}