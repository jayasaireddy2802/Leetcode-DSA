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

    int maxi;
    public int maximumPathSum(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int leftSum = Math.max(0, maximumPathSum(node.left));
        int rightSum = Math.max(0, maximumPathSum(node.right));

        maxi = Math.max(maxi, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        maximumPathSum(root);
        maxi = Math.max(maxi, root.val);
        return maxi;
    }
}