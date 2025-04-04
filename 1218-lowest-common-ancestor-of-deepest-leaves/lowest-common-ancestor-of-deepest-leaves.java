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
    int maxdepth = 0;

    public TreeNode lca(int lvl, int maxdepth, TreeNode node)
    {
        if(node == null)
            return null;
        if(lvl == maxdepth)
            return node;
        
        TreeNode left = lca(lvl + 1, maxdepth, node.left);
        TreeNode right = lca(lvl + 1, maxdepth, node.right);

        if(left != null && right != null)
            return node;
        if(right != null)
            return right;
        if(left != null)
            return left;
        return null;
    }

    public void depth(TreeNode node, int lvl, Map<TreeNode, Integer> map)
    {
        if(node == null)
            return ;
        
        map.put(node, lvl);
        maxdepth = Math.max(maxdepth, lvl);
        depth(node.left, lvl+1,map);
        depth(node.right,lvl+1,map);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxdepth = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        depth(root, 0, map);        
        return lca(0, maxdepth, root);        
    }
}