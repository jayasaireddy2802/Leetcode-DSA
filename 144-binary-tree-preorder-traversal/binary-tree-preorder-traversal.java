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

//  using recusion
// class Solution {
//     List<Integer> list;

//     public void preorder(TreeNode node)
//     {
//         if(node == null)
//             return ;
//         list.add(node.val);
//         preorder(node.left);
//         preorder(node.right);
//     }   

//     public List<Integer> preorderTraversal(TreeNode root) {
//         list = new ArrayList<>();
//         preorder(root);
//         return list;

//     }
// }

// using iterative approach
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null)
            return list;

        st.add(root);

        while(!st.isEmpty())
        {
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null)
                st.add(node.right);
            if(node.left != null)
                st.add(node.left);
        }

        return list;

    }
}