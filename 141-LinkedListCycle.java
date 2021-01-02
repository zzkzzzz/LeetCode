import java.util.HashSet;

class Solution141 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        HashSet<ListNode> visited = new HashSet<>();

        while (head.next != null) {
            if (visited.contains(head))
                return true;

            visited.add(head);
            head = head.next;
        }

        return false;
    }

    // two pointers
    // if the Linked List has a cycle walker and runner will meet at some point.
    public boolean hasCycle2(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }
}