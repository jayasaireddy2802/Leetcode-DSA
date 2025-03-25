/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);
        queue.add(root);

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

        Set<TreeNode> visited = new HashSet<>();

        queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            if(level == k)
                break;
            for(int i = 0; i < size; i++)
            {
            TreeNode node = queue.poll();
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
            if(map.get(node) != null && (!visited.contains(map.get(node))))
            {
                queue.add(map.get(node));
                visited.add(map.get(node));
            }
            }
            level++;
            
        }
        
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty())
        {
            list.add(queue.poll().val);
        }
        return list;
    }
}