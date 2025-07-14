/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if(head == null)
            return 0;
        ListNode curr = head;
        String str = "";
        while(curr != null)
        {
            if(curr.val == 1)
                str = str + '1';
            else
                str = str + '0';
            curr = curr.next;
        }

        return Integer.parseInt(str, 2);
    }
}