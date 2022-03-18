public class Solution {

    private static ListNode root;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
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
        root = node1;


        reverseBetween(node1, 2, 4);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode sHead = new ListNode();
        ListNode sTail = sHead;
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            if (count == left) {
                ListNode[] rev = reverse(temp, right-count+1);
                sTail.next = rev[0];
                rev[1].next = rev[2];
                return sHead.next;
            }
            sTail.next = temp;
            sTail = temp;
            temp = temp.next;
        }
        return sHead.next;
    }

    private static ListNode[] reverse(ListNode n1, int right) {
        ListNode sTail = null, sHead = null;
        int count = 0;

        while (n1 != null) {
            count++;
            ListNode next = n1.next;
            n1.next = sHead;
            sHead = n1;
            if (sTail == null) {
                sTail = sHead;
            }
            if (count == right) {
                return new ListNode[]{sHead, sTail, next};
            }

            n1 = next;
        }
        return new ListNode[]{sHead, sTail, null};
    }
}
