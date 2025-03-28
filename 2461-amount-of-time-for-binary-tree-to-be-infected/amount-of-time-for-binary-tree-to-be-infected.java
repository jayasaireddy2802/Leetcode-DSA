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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(root);
        map.put(root, null);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.left != null)
            {
                queue.add(node.left);
                map.put(node.left, node);
            }
            if(node.right != null)
            {
                queue.add(node.right);
                map.put(node.right, node);
            }
        }

        queue.add(root);
        TreeNode target = null;

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.val == start){
                target = node;
                break;
            }
            if(node.left != null)
            {
                queue.add(node.left);
            }
            if(node.right != null)
            {
                queue.add(node.right);
            }
        }

        queue.clear();
        queue.add(target);
        visited.add(target);

        int time = -1;
    
        while(!queue.isEmpty())
        {
            int size = queue.size();
            time++;

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                TreeNode parent = map.get(node);

                if(node.left != null && (!visited.contains(node.left)))
                {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && (!visited.contains(node.right)))
                {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(parent != null && (!visited.contains(parent)))
                {
                    queue.add(parent);
                    visited.add(parent);
                }
            }

        }

        return time;
    }
}