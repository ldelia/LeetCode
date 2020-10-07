class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) return head;
        
        int len = 0;
        
        ListNode pHead = head;
        ListNode pLast = null;
        
        while (pHead != null) {
            len++;
            pLast = pHead;
            pHead = pHead.next;
        }
        
        int kMod = k % len;
        
        if (kMod == 0) return head;
        
        pHead = head;
        for (int i=1; i<len-kMod; i++) {
            pHead = pHead.next;
        }
        ListNode newHead = pHead.next;
        pLast.next = head;
        pHead.next = null;
        
        return newHead;
    }
}