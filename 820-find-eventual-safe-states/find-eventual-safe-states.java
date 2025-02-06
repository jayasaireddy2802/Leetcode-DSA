class Solution {

    public boolean dfs(int i, boolean[] visited, boolean[] pathVisited, int[][] graph)
    {
        visited[i] = true;
        pathVisited[i] = true;

        for(int neighbour : graph[i])
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, visited, pathVisited, graph))
                    return true;

            }
            else if (pathVisited[neighbour])
                return true;
        }

        pathVisited[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < v; i++)
        {
            if(!visited[i])
            {
                dfs(i, visited, pathVisited, graph);
            }

        }

        for(int i = 0; i < v; i++)
        {
            if(!pathVisited[i])
                ans.add(i);
        }

        return ans;
    }
}