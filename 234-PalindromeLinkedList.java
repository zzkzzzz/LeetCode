class Solution234 {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;

        // 1. find middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse second half
        ListNode l2 = reverse(slow);

        // 3. compare two halves
        return compare(l1, l2);

    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    boolean compare(ListNode head1, ListNode head2) {
        while (head2 != null) {
            if (head1.val != head2.val)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}