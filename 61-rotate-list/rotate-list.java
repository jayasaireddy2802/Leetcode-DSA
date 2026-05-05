class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode temp = head;

        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
 
        temp.next = head;
        k = k % len;
        if (k == 0) {
            temp.next = null;
            return head;
        }
        int stepsToNewHead = len - k;

        temp = head;

        for (int i = 1; i < stepsToNewHead; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}