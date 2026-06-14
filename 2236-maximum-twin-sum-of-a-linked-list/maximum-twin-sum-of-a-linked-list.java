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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }

        int len = list.size();
        int i = 0, j = len - 1;
        int max = 0;

        while(i < j)
        {
            max = Math.max(max, list.get(i) + list.get(j));
            i++;
            j--;
        }

        return max;

    }
}