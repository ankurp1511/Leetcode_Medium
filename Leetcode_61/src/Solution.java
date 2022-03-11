public class Solution {

     static private ListNode root;

     public static class ListNode {
         int val;
         ListNode next;

         public ListNode() {
         }

         ListNode(int val) {
             this.val = val;
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

         ListNode node = rotateRight(root, 10);
         print(node);

    }

    public static ListNode rotateRight(ListNode head, int k) {

        ListNode sHead = new ListNode();
        ListNode fast = head;
        ListNode slow = head;
        ListNode lTail = null;
        ListNode rTail = null;

        int length = 0;
        sHead.next = head;

        for (int i=0; i<= k; i++) {
            if (fast == null && (k == length || k % length == 0)) {
                return slow;
            } else if (fast == null && k > length) {
                k = k%length;
                fast = head;
                for (int j = 0; j <= k; j++) {
                    if (fast.next == null) {
                        rTail = fast;
                    }
                    fast = fast.next;
                }
                break;
            }
            if (fast.next == null) {
                rTail = fast;
            }
            fast = fast.next;
            length++;
        }

        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                rTail = fast;
                break;
            }
            fast = fast.next;
        }

        lTail = slow.next;
        slow.next = null;
        rTail.next = head;
        sHead.next = lTail;

        return sHead.next;

    }

    private static void print (ListNode root) {

         ListNode temp = root;
        while (temp != null) {
             System.out.print(temp.val + " ");
             temp = temp.next;
         }
    }
}
