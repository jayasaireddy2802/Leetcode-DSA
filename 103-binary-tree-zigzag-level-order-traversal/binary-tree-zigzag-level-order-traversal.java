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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if(flag == true)
                    list.add(node.val);
                else
                    list.add(0, node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            ans.add(list);
            flag = (flag == true) ? false : true ;
        }

        return ans;
    }
}