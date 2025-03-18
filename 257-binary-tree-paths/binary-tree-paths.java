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

    private boolean isLeaf(TreeNode node)
    {
        return (node.left == null && node.right == null);
    }

    public void inorder(TreeNode node, List<String> ans, List<Integer> list)
    {
        if(node == null)
            return ;
        if(isLeaf(node))
        {
            String str = "";
            for(int num : list)
                str = str + Integer.toString(num) + "->";
            str = str + Integer.toString(node.val);
            ans.add(str);
            
        } 
        list.add(node.val);
        inorder(node.left, ans, list);
        inorder(node.right, ans, list);
        list.remove(list.size() - 1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        inorder(root, ans, list);
        return ans;
    }
}