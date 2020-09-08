/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    Memory Usage: 38.9 MB, less than 81.26% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    */
    public int sumRootToLeaf(TreeNode root) {
        
        if (root == null) return 0;
        
        return sumRootToLeaf(root, 0);
    }
    
    protected int sumRootToLeaf(TreeNode root, int sum) {
        
        int currentSum = sum * 2 + root.val;

        if (root.left == null && root.right == null) {
            return currentSum;    
        }
        
        int result = 0;
        if (root.left != null) result += sumRootToLeaf(root.left, currentSum);
        if (root.right != null) result += sumRootToLeaf(root.right, currentSum);
        
        return result;
    }
}