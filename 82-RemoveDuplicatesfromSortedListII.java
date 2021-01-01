class Solution82 {

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;
        pre.next = head;
        boolean duplicate = false;

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
                duplicate = true;
            } else {
                if (duplicate) {
                    pre.next = curr.next;
                    curr = curr.next;
                    duplicate = false;
                } else {
                    pre = curr;
                    curr = curr.next;
                }

            }
        }

        if (duplicate) {
            pre.next = curr.next;
        }

        return dummy.next;
    }
}