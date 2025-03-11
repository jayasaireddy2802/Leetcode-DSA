// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode oddEvenList(ListNode head) {
//         ListNode curr = head;
//         ListNode evenHead = new ListNode(-1);
//         ListNode oddHead = new ListNode(-1);
//         ListNode even = evenHead;
//         ListNode odd = oddHead;
//         int flag = 1;

//         while(curr != null)
//         {
//             if(flag == 0)
//             {
//                 ListNode temp = new ListNode(curr.val);
//                 even.next = temp;
//                 even = temp;
//                 flag = 1;
//             }
//             else
//             {
//                 ListNode temp = new ListNode(curr.val);
//                 odd.next = temp;
//                 odd = temp;
//                 flag = 0;
//             }

//             curr = curr.next;
//         }

//         oddHead = oddHead.next;
//         odd.next = evenHead.next;

//         return oddHead;
//     }
// }


// space O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;

    }
}