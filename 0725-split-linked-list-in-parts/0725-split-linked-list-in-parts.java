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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;

        while(curr != null){
            len++;
            curr = curr.next;
        }

        int size = len / k;
        int extra = len % k;

        ListNode[] ans = new ListNode[k];
        curr = head;

        for(int i = 0; i < k; i++){
            ans[i] = curr;

            int partSize = size;

            if(extra > 0){
                partSize++;
                extra--;
            }

            for(int j = 1; j < partSize; j++){
                if(curr != null) {
                    curr = curr.next;
                }
            }

            if(curr != null){
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return ans;
    }
}