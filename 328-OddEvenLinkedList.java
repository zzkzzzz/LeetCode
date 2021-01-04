class Solution328 {

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

    // recursive
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        var headEven = oddEvenList(head, head.next);
        var headOdd = head;

        while (head.next != null) {
            head = head.next;
        }
        head.next = headEven;

        return headOdd;
    }

    private ListNode oddEvenList(ListNode node, ListNode nextNode) {
        if (nextNode == null) {
            return nextNode;
        }
        node.next = oddEvenList(nextNode, nextNode.next);
        return nextNode;
    }

    // iterative
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}