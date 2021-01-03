public class Solution160 {

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

    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, then we will stop the loop after second
        // iteration
        while (a != b) {
            // for the end of first iteration, we just reset the pointer to the head of
            // another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    // 1, Get the length of the two lists.
    // 2, Align them to the same start point.
    // 3, Move them together until finding the intersection point, or the end null
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}