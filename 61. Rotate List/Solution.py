class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        
        if head is None or head.next is None or k == 0:
            return head
        
        listLength = 0;
        
        pHead = head
        pLast = None
        
        while pHead is not None:
            listLength += 1
            pLast = pHead
            pHead = pHead.next
            
        kMod = k % listLength
        
        if kMod == 0:
            return head
        
        pLast.next = head
        pHead = head
        
        for i in range(1,listLength-kMod):
            pHead = pHead.next
            
        newHead = pHead.next
        pHead.next = None
        
        return newHead
        