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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        ListNode evenHead = new ListNode(-1);
        ListNode oddHead = new ListNode(-1);
        ListNode even = evenHead;
        ListNode odd = oddHead;
        int flag = 0;

        while(curr != null)
        {
            if(flag == 0)
            {
                ListNode temp = new ListNode(curr.val);
                even.next = temp;
                even = temp;
                flag = 1;
            }
            else
            {
                ListNode temp = new ListNode(curr.val);
                odd.next = temp;
                odd = temp;
                flag = 0;
            }

            curr = curr.next;
        }

        evenHead = evenHead.next;
        even.next = oddHead.next;

        return evenHead;
    }
}