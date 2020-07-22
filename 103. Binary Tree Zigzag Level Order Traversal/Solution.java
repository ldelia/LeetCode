/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    Memory Usage: 38.5 MB, less than 73.60% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    */
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        helper(root, 0, result);
        
        return result;
    }
    
    protected void helper(TreeNode root, int level, List<List<Integer>> result) {
        
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add( new LinkedList<>() );
        }
        
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            ((LinkedList) result.get(level)).addFirst(root.val);
        }
        
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}