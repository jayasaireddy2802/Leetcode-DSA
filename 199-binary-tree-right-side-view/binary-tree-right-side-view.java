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

class Pair{
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level)
    {
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0;

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty())
        {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            map.put(level, node.val);

            if(node.left != null)
                queue.add(new Pair(node.left, level + 1));
            if(node.right != null)
                queue.add(new Pair(node.right, level + 1));

            maxi = Math.max(maxi, level + 1);
        }

        for(int key = 0; key < maxi; key++)
            ans.add(map.get(key));
        
        return ans;
    }
}