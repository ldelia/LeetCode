/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    /**
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
    Memory Usage: 37.6 MB, less than 55.54% of Java online submissions for Flatten a Multilevel Doubly Linked List.
    */
    
    public Node flatten(Node head) {
        return flatten(head, null);
    }
    
    protected Node flatten(Node head, Node tail) {
        
        Node lastNode = null;
        Node currentNode = head;
        
        while (currentNode != null) {
            if (currentNode.child != null) {
                Node flattenSubList = flatten(currentNode.child, currentNode.next);
                flattenSubList.prev = currentNode;
                
                Node priorNextNode = currentNode.next;
                
                currentNode.child = null;
                currentNode.next = flattenSubList;
                
                if (priorNextNode != null){
                    lastNode = priorNextNode.prev;    
                }
                currentNode = priorNextNode;
                
            } else {
                lastNode = currentNode;
                currentNode = currentNode.next;                
            }
        }
        
        if (lastNode != null) {
            lastNode.next = tail;
            if (tail != null) {
                tail.prev = lastNode;                
            }            
        }
        
        return head;
    }
}