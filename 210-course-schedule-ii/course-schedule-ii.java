// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int q = prerequisites.length;
//         int j = 0;
//         List<List<Integer>> adj = new ArrayList<>();
//         List<Integer> list = new ArrayList<>();
//         Queue<Integer> queue = new LinkedList<>();
//         int[] indegre = new int[numCourses];
//         int[] ans = new int[numCourses];

//         for(int i = 0; i < numCourses; i++)
//             adj.add(new ArrayList<>());

//         for(int[] arr : prerequisites)
//         {
//             adj.get(arr[1]).add(arr[0]);
//             indegre[arr[0]]++;
//         }
        
//         for(int i = 0; i < numCourses; i++)
//         {
//             if(indegre[i] == 0)
//             {
//                 queue.add(i);
//                 list.add(i);
//                 ans[j] = i;
//                 j++;
//             }
//         }

//         while(!queue.isEmpty())
//         {
//             int node = queue.poll();

//             for(int neighbour : adj.get(node))
//             {
//                 indegre[neighbour]--;
//                 if(indegre[neighbour] == 0)
//                 {
//                     queue.add(neighbour);
//                     list.add(neighbour);
//                     ans[j] = neighbour;
//                     j++;
//                 }
//             }

//         }

//         return (list.size() == numCourses) ? ans : new int[0];

//     }
// }



class Solution {

    public boolean dfs(int i, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj, Stack<Integer> st)
    {
        visited[i] = true;
        pathVisited[i] = true;

        for(int neighbour : adj.get(i))
        {
            if(pathVisited[neighbour])
                return true;
            if(!visited[neighbour])
            {
                if(dfs(neighbour, visited, pathVisited, adj, st))
                    return true;
            }
        }

        pathVisited[i] = false;
        st.add(i);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int q = prerequisites.length;
        int j = 0;
        List<List<Integer>> adj = new ArrayList<>();
        int[] ans = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
        }
        
        for(int i = 0; i < numCourses; i++)
        {
            if(!visited[i])
                if(dfs(i, visited, pathVisited,adj, st))
                    return new int[0];
        }

        if(st.size() == numCourses)
        {
            for(int i = 0; i < numCourses; i++)
            {
                ans[i] = st.pop();
            }
            return ans;
        }
        return new int[0];

        

    }
} 