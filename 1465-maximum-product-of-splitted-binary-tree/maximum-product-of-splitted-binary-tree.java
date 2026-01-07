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

    long maxi;
    int mod = 1000000007;

    public long getSum(TreeNode root)
    {
        if(root == null)
            return 0;

        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);
        return root.val + leftSum + rightSum;
    }

    public long findMaxProduct(TreeNode root, long totalSum)
    {
        if(root == null)
            return 0;

        long leftSum = findMaxProduct(root.left, totalSum);
        long rightSum = findMaxProduct(root.right, totalSum);
        long s1 = root.val + leftSum + rightSum;
        long s2 = totalSum - s1;

        maxi = Math.max(maxi, (s1*s2));
        return s1;        
    }

    public int maxProduct(TreeNode root) {
        long totalsum = getSum(root);
        maxi = 0;
        findMaxProduct(root, totalsum);
        return (int)(maxi%mod);
    }
}