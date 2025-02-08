// Using dfs

// class Solution {

//     public boolean dfs(int i, boolean[] visited, boolean[] pathVisited, int[][] graph)
//     {
//         visited[i] = true;
//         pathVisited[i] = true;

//         for(int neighbour : graph[i])
//         {
//             if(!visited[neighbour])
//             {
//                 if(dfs(neighbour, visited, pathVisited, graph))
//                     return true;

//             }
//             else if (pathVisited[neighbour])
//                 return true;
//         }

//         pathVisited[i] = false;
//         return false;
//     }

//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int v = graph.length;
//         boolean[] visited = new boolean[v];
//         boolean[] pathVisited = new boolean[v];
//         List<Integer> ans = new ArrayList<>();

//         for(int i = 0; i < v; i++)
//         {
//             if(!visited[i])
//             {
//                 dfs(i, visited, pathVisited, graph);
//             }

//         }

//         for(int i = 0; i < v; i++)
//         {
//             if(!pathVisited[i])
//                 ans.add(i);
//         }

//         return ans;
//     }
// }

// using bfs (kahn's algo)

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int v = graph.length;
        int[] indegre = new int[v];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < v; i++)
        {
            for(int x : graph[i])
            {
                adj.get(x).add(i);
                indegre[i]++;
            }
        }

        for(int i = 0; i < v; i++)
        {
            if(indegre[i] == 0)
            {
                queue.add(i);
                ans.add(i);
            }
        }

        while(!queue.isEmpty())
        {
            int node = queue.poll();

            for(int neighbour : adj.get(node))
            {
                indegre[neighbour]--;
                if(indegre[neighbour] == 0)
                {
                    queue.add(neighbour);
                    ans.add(neighbour);
                }

            }
        }

        Collections.sort(ans);
        return ans;
    }

}
