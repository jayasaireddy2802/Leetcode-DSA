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

    public boolean traverse(TreeNode node, TreeNode p, List<TreeNode> list)
    {
        if(node == null)
            return false;
        
        if(node == p)
        {
            list.add(node);
            return true;
        }

        list.add(node);
        boolean left = traverse(node.left, p, list);
        if(left)
            return left;
        boolean right = traverse(node.right, p, list);
        if(right)
            return right;
        
        list.remove(list.size() - 1);
        
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        traverse(root, p, path1);
        traverse(root, q, path2);

        for(TreeNode x : path1)
        System.out.println(x.val);
        for(TreeNode x : path2)
        System.out.println(x.val);

        int i = 0, j = 0;
        int m = path1.size(), n = path2.size();
        TreeNode ans = null;
        while(i < m && j < n)
        {
            if(path1.get(i) == path2.get(j))
            {
                ans = path1.get(i);
                i++;
                j++;
            }
            else
                break;
        }

        return ans;
    }
}