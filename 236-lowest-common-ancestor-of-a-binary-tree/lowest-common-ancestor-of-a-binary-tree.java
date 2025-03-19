/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {

//     public boolean traverse(TreeNode node, TreeNode p, List<TreeNode> list)
//     {
//         if(node == null)
//             return false;
        
//         if(node == p)
//         {
//             list.add(node);
//             return true;
//         }

//         list.add(node);
//         boolean left = traverse(node.left, p, list);
//         if(left)
//             return left;
//         boolean right = traverse(node.right, p, list);
//         if(right)
//             return right;
        
//         list.remove(list.size() - 1);
        
//         return false;
//     }

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> path1 = new ArrayList<>();
//         List<TreeNode> path2 = new ArrayList<>();
        
//         traverse(root, p, path1);
//         traverse(root, q, path2);

//         int i = 0, j = 0;
//         int m = path1.size(), n = path2.size();
//         TreeNode ans = null;
//         while(i < m && j < n)
//         {
//             if(path1.get(i) == path2.get(j))
//             {
//                 ans = path1.get(i);
//                 i++;
//                 j++;
//             }
//             else
//                 break;
//         }

//         return ans;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;
        
        if(root == p)
            return p;
        
        if(root == q)
            return q;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q); 
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;

    }
}