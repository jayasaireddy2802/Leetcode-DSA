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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] description : descriptions)
        {
            int parent = description[0];
            int child = description[1];
            int left = description[2];
            TreeNode parentNode = null;
            TreeNode childNode = null;

            
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            parentNode = map.get(parent);
            childNode = map.get(child);

            if(left == 1)
            {
                parentNode.left = childNode;
            }
            else
            {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for(int child : map.keySet())
        {
            if(!children.contains(child))
                return map.get(child);
        }

        return null;
        
    }
}