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

        removeNthFromEnd(head, 1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sHead = new ListNode(), fast = head, slow = head;

        sHead.next = head;

        for (int i=0 ; i<=n ; i++) {
            if (fast == null) {
                sHead.next = head.next;
                return sHead.next;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sHead.next;
    }

}
