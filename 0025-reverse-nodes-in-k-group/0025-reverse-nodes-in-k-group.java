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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head;

        while(curr != null){
            ListNode kth = curr;
            int count = 1;
            while(count < k && kth != null){
                kth = kth.next;
                count++;
            }
            if(kth == null){
                tail.next = curr;
                break;
            }
            ListNode nextGroup = kth.next;
            ListNode prev = nextGroup;
            ListNode temp = curr;
            while(temp != nextGroup){
                ListNode next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }

            tail.next = kth;
            tail = curr;
            curr = nextGroup;
        }
        return dummy.next;
    }
}