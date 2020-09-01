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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        /**
            Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
            Memory Usage: 39.9 MB, less than 67.64% of Java online submissions for Delete Node in a BST.        
        */
        
        TreeNode parent = null;
        TreeNode node = root;
        
        // Search for a node to remove.
        
        while (node != null && node.val != key) {
            parent = node;
            if (node.val > key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        // If the node is found, delete the node.
        
        if (node != null) {

            if (node.right != null) {
                node.val = pollMinimumValue(node.right, node, 1);    
            } else {
                if (parent != null) {
                    if (node.val < parent.val) {
                        parent.left = node.left;    
                    } else {
                        parent.right = node.left;
                    }
                } else {
                    return node.left;
                }
            }
        }
        
        return root;
        
    }
    
    protected int pollMinimumValue(TreeNode current, TreeNode parent, int leaf) {
        
        if (current.left == null) {
            // current.val is the minimum val. Remove the reference of its parent
            if (leaf == 1) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
            return current.val;
        } else {
            return pollMinimumValue(current.left, current, -1);
        }
    }
}