class Solution61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode start = head;
        ListNode end = head;
        ListNode newEnd = head;
        ListNode newStart = head;
        int size = 1;

        while (end.next != null) {
            end = end.next;
            size++;
        }

        k = k % size;

        if (k == 0)
            return head;

        int n = size - k;

        while (n > 1) {
            newEnd = newEnd.next;
            newStart = newStart.next;
            n--;
        }

        newStart = newStart.next;
        newEnd.next = null;
        end.next = start;

        return newStart;

    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int size = 1;
        while (fast.next != null) {
            fast = fast.next;
            size++;
        }
        k = k % size;
        int n = size - k;

        while (n > 1) {
            slow = slow.next;
            n--;
        }

        fast.next = dummy.next; // Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

}