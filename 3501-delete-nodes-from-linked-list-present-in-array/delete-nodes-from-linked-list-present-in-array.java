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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        List<Integer> res = new ArrayList<>();

        for(int num : nums)
            set.add(num);

        while(curr != null)
        {
            int val = curr.val;
            if(!set.contains(val))
                res.add(val);
            curr = curr.next;
        }


        ListNode head1 = new ListNode(-1);
        curr = head1;
        for(int num : res)
        {
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
        }
        
        return head1.next;
    }
}