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

    /**
    Runtime: 1 ms, faster than 90.05% of Java online submissions for Remove Linked List Elements.
    Memory Usage: 46.9 MB, less than 5.11% of Java online submissions for Remove Linked List Elements.
    */
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode pDummy = new ListNode(-1, head);
        
        ListNode pPrevious = pDummy;
        ListNode pHead = head;
        
        while (pHead != null) {
            
            if (pHead.val == val) {
                pPrevious.next = pHead.next;
            } else {
                pPrevious = pHead;    
            }
            
            pHead = pHead.next;
        }
        
        return pDummy.next;
    }
}