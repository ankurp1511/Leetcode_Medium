public class Solution {

    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = node1;
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode sHead = new ListNode(), sTail = sHead, node = head;

        while (node != null) {
            ListNode next = (node.next == null) ? null : node.next.next;

            if (node.next == null) {
                sTail.next = node;
                sTail = node;
            } else {
                node.next.next = null;
                sTail.next = node.next;
                sTail = node.next;

                sTail.next = node;
                node.next = null;
                sTail = node;
            }
            node = next;
        }
        return sHead.next;
    }
}
