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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {

            ListNode temp = curr.next;  //saving the current value in temp node
            curr.next = prev;           //storing the next in current 
            prev = curr;                //in this prev storing the current value
            curr = temp;                //noe the current stores the temp value
        }
        return prev;
    }
}