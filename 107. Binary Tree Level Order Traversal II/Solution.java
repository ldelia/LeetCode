class Solution {
    
    /**
    Runtime: 1 ms, faster than 80.39% of Java online submissions for Binary Tree Level Order Traversal II.
    Memory Usage: 39.6 MB, less than 69.15% of Java online submissions for Binary Tree Level Order Traversal II.
    */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new LinkedList<>();
        
        Deque<TreeNode> nodesFromCurrentLevel = new LinkedList<>();
        
        if (root != null)
            nodesFromCurrentLevel.offer(root);
        
        while (! nodesFromCurrentLevel.isEmpty()) {
            
            result.add(0, new LinkedList<Integer>());
            Deque<TreeNode> nodesFromNextLevel = new LinkedList<>();

            while (! nodesFromCurrentLevel.isEmpty()) {

                TreeNode node = nodesFromCurrentLevel.poll();

                if (node.left != null) 
                    nodesFromNextLevel.offer(node.left);    
                if (node.right != null) 
                    nodesFromNextLevel.offer(node.right);

                result.get(0).add(node.val);
            }
            
            nodesFromCurrentLevel = nodesFromNextLevel;
        }
        
        return result;
    }
}