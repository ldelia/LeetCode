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
    Runtime: 2 ms, faster than 77.11% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    Memory Usage: 39.8 MB, less than 38.51% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if (postorder.length == 0) return null;
        
        Map<Integer, Integer> mapInorder = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            mapInorder.put(inorder[i], i);
        }
        
        return buildTree(mapInorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
            
    }
    
    protected TreeNode buildTree(Map<Integer, Integer> mapInorder, int[] postorder, int inorderLo, int inorderHi, int postorderLo, int postorderHi) {
        
        if (postorderLo > postorderHi) return null;
        if (postorderLo == postorderHi) return new TreeNode(postorder[postorderLo]);
        
        int i = mapInorder.get(postorder[postorderHi]);
        int diff = i - inorderLo;
        
        TreeNode root = new TreeNode(postorder[postorderHi]);
        root.left = buildTree(mapInorder, postorder, inorderLo, inorderLo+diff-1, postorderLo, postorderLo+diff-1); 
        root.right = buildTree(mapInorder, postorder, i+1, inorderHi, postorderLo+diff, postorderHi-1);
        
        return root;
    }
}