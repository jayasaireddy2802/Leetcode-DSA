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
    int num;
    public Pair(TreeNode node, int num)
    {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();

        if(root == null)
            return 0;
        
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty())
        {
            int mini = queue.peek().num;
            int size = queue.size();
            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i++)
            {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int num = pair.num - mini;

                if(i == 0)
                    first = num;
                if(i == size - 1);
                    last = num;

                if(node.left != null)
                {
                    queue.add(new Pair(node.left, 2*(num) + 1));
                }
                if(node.right != null)
                {
                    queue.add(new Pair(node.right, 2*(num) + 2));
                   
                }
            }
            ans = Math.max(ans, last - first + 1);


        }

        return ans;
        
    }
}