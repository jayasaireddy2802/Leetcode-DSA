class Solution {
    int ans = -1;

    public void dfs(int i, boolean[] pathVisited, boolean[] visited, int[] count, int x, List<List<Integer>> adj)
    {
        visited[i] = true;
        pathVisited[i] = true;
        

        for(int neighbour : adj.get(i))
        {
            if(!visited[neighbour])
            {
                count[neighbour] = x + 1;
                dfs(neighbour, pathVisited, visited, count, x+1, adj);
            }
            else if(pathVisited[neighbour])
            {
                ans = Math.max(ans, (x+1) - count[neighbour] );
            }
            
        }

        pathVisited[i] = false;

    }

    public int longestCycle(int[] edges) {
        int v = edges.length;
        ans = -1;
        boolean[] visited = new boolean[v];
        int[] count = new int[v];
        boolean[] pathVisited = new boolean[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < v; i++)
        {
            if(edges[i] != -1)
                adj.get(i).add(edges[i]);
        }
        for(int i = 0; i < v; i++)
        {
            if(!visited[i])
            {
                count = new int[v];
                dfs(i, pathVisited, visited, count, 0, adj);
            }
        }

        return ans;
    }
}