class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

	    /**
	    Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
		Memory Usage: 39.2 MB, less than 5.05% of Java online submissions for Same Tree.
		*/
	        
        if (p == null || q == null) return p == q;
        
        return isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
    }
}