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
    public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> map)
    {
        if(prestart > preend || instart > inend)
            return null;
        
        TreeNode node = new TreeNode(preorder[prestart]);

        int idx = map.get(preorder[prestart]);
        int num = idx - instart;

        node.left = buildTree(preorder, prestart + 1, prestart + num, inorder, instart, idx - 1, map);
        node.right = buildTree(preorder, prestart + num +1, preend, inorder, idx + 1, inend, map);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

    }
}