class Solution86 {

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

    // the basic idea is to maintain two queues, the first one stores all nodes with
    // val less than x , and the second queue stores all the rest nodes.
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0); // dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2; // current tails of the two queues;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }

        // important! avoid cycle in linked list. otherwise u will get TLE.
        // For this list: 5->6->1->2, x=3, at last cur2 points to 6, cur1 points to 2,
        // we must set 6->1 to 6->null, otherwise there will be a cycle.
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;

    }
}