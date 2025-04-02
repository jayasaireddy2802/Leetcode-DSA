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

    public TreeNode tree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, Map<Integer, Integer> map)
    {
        if(instart > inend || poststart > postend)
            return null;
        
        TreeNode root = new TreeNode(postorder[postend]);

        int idx = map.get(postorder[postend]);
        int val = idx - instart;

        root.left = tree(inorder, instart, idx - 1, postorder, poststart, poststart+val-1, map);
        root.right = tree(inorder, idx + 1, inend, postorder, poststart+val, postend-1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            map.put(inorder[i], i);
        }
        
        return tree(inorder, 0, len - 1, postorder, 0, len - 1, map);
    }
}