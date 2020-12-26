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
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    Memory Usage: 36.5 MB, less than 67.10% of Java online submissions for Swap Nodes in Pairs.    
    */
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode nextBreakPointNode = head.next.next;
        
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextBreakPointNode);
        
        return newHead;
    }
}