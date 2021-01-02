import java.util.HashSet;

class Solution142 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        HashSet<ListNode> visited = new HashSet<>();

        while (head.next != null) {
            if (visited.contains(head))
                return head;

            visited.add(head);
            head = head.next;
        }

        return null;
    }

    // Floyd's cycle detection algorithm
    // explainion: https://www.youtube.com/watch?v=LUm2ABqAs1w
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
