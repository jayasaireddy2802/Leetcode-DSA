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
    int ct = 0;
    void solve(TreeNode r)
    {
        if(r == null)
        return ;
        solve(r.left);
        solve(r.right);
        ct++;
    }

    public int countingNodes(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int lh = findheightLeft(root);
        int rh = findheightRight(root);

        if(lh == rh) return (1 << lh) - 1;

        else return 1 + countingNodes(root.left) + countingNodes(root.right);
    }

    public int findheightLeft(TreeNode node)
    {
        int height = 0;
        while(node != null)
        {
            node = node.left;
            height++;
        }
        return height;
    }

    public int findheightRight(TreeNode node)
    {
        int height = 0;
        while(node != null)
        {
            node = node.right;
            height++;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        // solve(root);
        return countingNodes(root);

        
    }
}