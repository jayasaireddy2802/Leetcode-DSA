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

//  class Pair
//  {
//     TreeNode node;
//     int level;
//     int data;
//     int vertical;

//     public Pair(TreeNode node, int level, int vertical, int data)
//     {
//         this.node = node;
//         this.level = level;
//         this.vertical = vertical;
//         this.data = data;
//     }
//  }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Map<Integer, List<Pair>> map = new TreeMap<>();
//         Queue<Pair> queue = new LinkedList<>();

//         if(root == null)
//             return ans;
        
//         queue.add(new Pair(root, 0, 0, root.val));

//         while(!queue.isEmpty())
//         {
//             Pair pair = queue.poll();
//             TreeNode node = pair.node;
//             int level = pair.level;
//             int vertical = pair.vertical;

//             List<Pair> list = map.getOrDefault(vertical, new ArrayList<>());
//             list.add(pair);
//             map.put(vertical, list);

//             if(node.left != null)
//                 queue.add(new Pair(node.left, level + 1, vertical - 1, node.left.val));
//             if(node.right != null)
//                 queue.add(new Pair(node.right, level + 1, vertical + 1, node.right.val));
//         }

//         for(int key : map.keySet())
//         {
//             List<Integer> l = new ArrayList<>();
//             List<Pair> list = map.get(key);
//             Collections.sort(list, (a, b) -> (a.level == b.level) ? a.data - b.data : a.level - b.level);
//             for(Pair node : list)
//             {
//                 l.add(node.data);
//             }
//             ans.add(l);            
//         }

//         return ans;
//     }
// }



// class Pair
//  {
//     TreeNode node;
//     int level;
//     int data;
//     int vertical;

//     public Pair(TreeNode node, int level, int vertical, int data)
//     {
//         this.node = node;
//         this.level = level;
//         this.vertical = vertical;
//         this.data = data;
//     }
//  }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Map<Integer, List<Pair>> map = new HashMap<>();
//         Queue<Pair> queue = new LinkedList<>();
//         int mini = 0;
//         int maxi = Integer.MIN_VALUE;

//         if(root == null)
//             return ans;
        
//         queue.add(new Pair(root, 0, 0, root.val));

//         while(!queue.isEmpty())
//         {
//             Pair pair = queue.poll();
//             TreeNode node = pair.node;
//             int level = pair.level;
//             int vertical = pair.vertical;

//             List<Pair> list = map.getOrDefault(vertical, new ArrayList<>());
//             list.add(pair);
//             map.put(vertical, list);

//             if(node.left != null){
//                 queue.add(new Pair(node.left, level + 1, vertical - 1, node.left.val));
//                 mini = Math.min(mini, vertical - 1);
//             }
//             if(node.right != null){
//                 queue.add(new Pair(node.right, level + 1, vertical + 1, node.right.val));
//                 maxi = Math.max(maxi, vertical + 1);
//             }
//         }

//         for(int key = mini; key <= maxi; key++)
//         {
//             List<Integer> l = new ArrayList<>();
//             List<Pair> list = map.get(key);
//             Collections.sort(list, (a, b) -> (a.level == b.level) ? a.data - b.data : a.level - b.level);
//             for(Pair node : list)
//             {
//                 l.add(node.data);
//             }
//             ans.add(l);            
//         }

//         return ans;
//     }
// }




class Pair
 {
    TreeNode node;
    int level;
    int data;
    int vertical;

    public Pair(TreeNode node, int level, int vertical, int data)
    {
        this.node = node;
        this.level = level;
        this.vertical = vertical;
        this.data = data;
    }
 }
class Solution {
    int mini = 0;
    int maxi = Integer.MIN_VALUE;

    public void dfs(int row, int col, TreeNode node, PriorityQueue<Pair> pq)
    {
        if(node == null)
            return ;
        pq.add(new Pair(node, row, col, node.val));
        dfs(row + 1, col - 1, node.left, pq);
        mini = Math.min(mini, col - 1);
        dfs(row + 1, col + 1, node.right, pq);
        maxi = Math.max(maxi, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.level == b.level) ? a.data - b.data : a.level - b.level);
        Map<Integer, List<Integer>> map = new HashMap<>();

        if(root == null)
            return ans;
        
        dfs(0, 0, root,pq);

        while(!pq.isEmpty())
        {
            Pair pair = pq.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            int vertical = pair.vertical;

            List<Integer> list = map.getOrDefault(vertical, new ArrayList<>());
            list.add(node.val);
            map.put(vertical, list);
        }
        
        for(int key = mini + 1; key < maxi; key++)
        {
            // List<Integer> l = new ArrayList<>();
            List<Integer> list = map.get(key);
            // Collections.sort(list, (a, b) -> (a.level == b.level) ? a.data - b.data : a.level - b.level);
            // for(Pair node : list)
            // {
            //     l.add(node.data);
            // }
            ans.add(list);            
        }

        return ans;
    }
}