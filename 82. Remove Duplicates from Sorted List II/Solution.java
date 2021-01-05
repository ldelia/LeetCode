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
    // 10 min
    /***
    Your runtime beats 100.00 % of java submissions.
    Your memory usage beats 86.60 % of java submissions.
    */
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        
        ListNode pLast = dummy;
        ListNode pHead = dummy.next;
        
        while (pHead != null) { 
            if (pHead.next != null && pHead.val == pHead.next.val) {
                // remove duplicates
                while (pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                pLast.next = pHead.next;
                pHead = pLast.next;
            } else {
                pLast = pHead;
                pHead = pHead.next;
            }
        }
        
        return dummy.next;
    }
}