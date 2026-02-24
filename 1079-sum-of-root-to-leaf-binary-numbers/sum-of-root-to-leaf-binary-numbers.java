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
    int sum = 0;

    public void preOrder(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            return ;
        
        sb.append(root.val);

        if(root.left == null && root.right == null)
        {
            String str = sb.toString();
            sum = sum + Integer.parseInt(str, 2);
        }
        else{
        preOrder(root.left, sb);
        preOrder(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        preOrder(root, new StringBuilder());
        return sum;
    }
}