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

//  using recursion
// class Solution {
//     List<Integer> l = new ArrayList<>();

//     public void inorder(TreeNode r){
//         if(r == null)
//         {
//             return ;
//         }
//         inorder(r.left);
//         l.add(r.val);
//         inorder(r.right);
//     }

//     public List<Integer> inorderTraversal(TreeNode root) {
//         inorder(root);
//         return l;
//     }
// }

// using iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while(true)
        {
            if(node != null)
            {
                st.push(node);
                node = node.left;
            }
            else
            {
                if(!st.isEmpty())
                {
                    node = st.pop();
                    list.add(node.val);
                    node = node.right;
                }
                else
                    break;
            }
        }

        return list;
    }
}