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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        
        verticalTraversal(root, 0, 0, map);
        
        List<List<Integer>> result = new LinkedList<>();
        
        for (Map.Entry entry : map.entrySet()) {
            
            List<Integer> subList = new LinkedList<>();
            
            List<int[]> queue = (List) entry.getValue();            
            Collections.sort(queue, (a,b)-> (a[0]==b[0]) ? a[1] - b[1] : a[0] - b[0]);
            for (int[] val : queue) {
                subList.add(val[1]);
            }
            
            result.add(subList);
        }
        
        return result;
    }
    
    public void verticalTraversal(TreeNode root, int index, int level, TreeMap<Integer, List<int[]>> map) {
        
        if (root == null) return;
        
        verticalTraversal(root.left, index-1, level+1, map);        
        
        List<int[]> values = map.getOrDefault(index, new LinkedList<>());
        values.add(new int[]{ level, root.val });        
        map.put(index,values);

        verticalTraversal(root.right, index+1, level+1, map);
    }
}