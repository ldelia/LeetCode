/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            slow = slow.next;
            
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null) return null;
        
        // There is a cycle
        
        slow = head;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}