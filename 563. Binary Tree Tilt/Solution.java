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
    public int findTilt(TreeNode root) {
        
        /**
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Tilt.
        Memory Usage: 39.3 MB, less than 7.42% of Java online submissions for Binary Tree Tilt.
        */
        int[] ans = findTiltHelper(root);
        return ans[1];
        
    }
    
    protected int[] findTiltHelper(TreeNode root) {
        
        if (root == null) return new int[]{0,0};
        
        int[] leftSum = findTiltHelper(root.left);
        int[] rightSum = findTiltHelper(root.right);
        
        int[] ans = new int[2];
        ans[0] = leftSum[0] + rightSum[0] + root.val;
        ans[1] = Math.abs(leftSum[0] - rightSum[0]) + leftSum[1] + rightSum[1];

        return ans;          
    }
}