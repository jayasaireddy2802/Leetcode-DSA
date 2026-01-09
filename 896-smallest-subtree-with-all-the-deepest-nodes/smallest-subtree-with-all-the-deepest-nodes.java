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

    Map<Integer, Integer> depthMap = new HashMap<>();
    int deepestLevel = 0;

    TreeNode findLCA(TreeNode node) {
        if (node == null || depthMap.getOrDefault(node.val, -1) == deepestLevel) {
            return node;
        }

        TreeNode left = findLCA(node.left);
        TreeNode right = findLCA(node.right);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }

    void calculateDepth(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        deepestLevel = Math.max(deepestLevel, level);
        depthMap.put(node.val, level);

        calculateDepth(node.left, level + 1);
        calculateDepth(node.right, level + 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        calculateDepth(root, 0);
        return findLCA(root);
    }
}
