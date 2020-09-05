class Solution {
    
    /*
    Runtime: 16 ms, faster than 67.09% of Java online submissions for All Elements in Two Binary Search Trees.
    Memory Usage: 42.1 MB, less than 90.55% of Java online submissions
    */
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        
        inorder(root1, list1);
        inorder(root2, list2);
        
        int size = list1.size() + list2.size();
        ArrayList<Integer> result = new ArrayList<>(size);
        
        while (result.size() < size) {
            
            if (list1.isEmpty() || list2.isEmpty()) {
                result.addAll( list1.isEmpty() ? list2 : list1 );
            } else {
                int min = Math.min(list1.peekFirst(), list2.peekFirst());
                result.add(min);

                if (list1.peekFirst() == min) {
                    list1.removeFirst();
                } else {
                    list2.removeFirst();
                }
            }
        }
            
        
        return result;
    }
    
    protected void inorder(TreeNode root1, LinkedList<Integer> list) { 
        
        if (root1 == null) return;
        
        inorder(root1.left, list);
        
        list.offer(root1.val);
        
        inorder(root1.right, list);
    }    
}