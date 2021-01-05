import java.util.Stack;
import java.util.Stack;

class Solution445 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        ;
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int change = 0;
        ListNode dummy = null;
        while (!s1.empty() || !s2.empty() || change != 0) {
            if (!s1.empty())
                sum += s1.pop();
            if (!s2.empty())
                sum += s2.pop();

            sum = sum + change;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummy;
            dummy = newNode;
            change = sum / 10;
            sum = 0;

        }

        return dummy;
    }
}