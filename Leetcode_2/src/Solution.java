public class Solution {

    static ListNode root1;
    static ListNode root2;

    static class ListNode {

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode() {

        }
    }

    public static void main(String[] args) {

        ListNode l1_node1 = new ListNode(9);
        ListNode l1_node2 = new ListNode(9);
        ListNode l1_node3 = new ListNode(9);
        ListNode l1_node4 = new ListNode(9);
        ListNode l1_node5 = new ListNode(9);
        ListNode l1_node6 = new ListNode(9);
        ListNode l1_node7 = new ListNode(9);

        l1_node1.next = l1_node2;
        l1_node2.next = l1_node3;
        l1_node3.next = l1_node4;
        l1_node4.next = l1_node5;
        l1_node5.next = l1_node6;
        l1_node6.next = l1_node7;
        root1 = l1_node1;

        ListNode l2_node1 = new ListNode(9);
        ListNode l2_node2 = new ListNode(9);
        ListNode l2_node3 = new ListNode(9);
        ListNode l2_node4 = new ListNode(9);

        l2_node1.next = l2_node2;
        l2_node2.next = l2_node3;
        l2_node3.next = l2_node4;
        root2 = l2_node1;

        addTwoNumbers(root1, root2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sHead = new ListNode();
        ListNode sTail = sHead;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        while (temp1 != null && temp2 != null) {
            int num1 = temp1.data;
            int num2 = temp2.data;

            sTail.next = new ListNode((num1 + num2 + carry)% 10);
            sTail = sTail.next;
            if (num1 + num2 + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            int num1 = temp1.data;
            sTail.next = new ListNode((num1 + carry)% 10);
            sTail = sTail.next;
            temp1 = temp1.next;
            if (num1 + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        while (temp2 != null) {
            int num1 = temp2.data;
            sTail.next = new ListNode((num1 + carry)% 10);
            sTail = sTail.next;
            temp2 = temp2.next;
            if (num1 + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) {
            sTail.next = new ListNode(1);
        }

        return sHead.next;
    }

}
