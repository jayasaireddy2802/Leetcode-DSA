class Solution {


    public void dfs(int i, boolean[] visited, List<List<Integer>> adj, List<Integer> list)
    {
        visited[i] = true;
        list.add(i);

        for(int neighbour : adj.get(i))
        {
            
            if(!visited[neighbour])
            {
                dfs(neighbour, visited, adj, list);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int ct = 0;

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                List<Integer> list = new ArrayList<>();
                dfs(i, visited, adj, list);
                
                boolean isComplete = true;
                int k = list.size() - 1;
                for(int node : list)
                {
                    if(adj.get(node).size() != k)
                    {
                        isComplete = false;
                        break;
                    }
                }

                if(isComplete)
                    ct++;
            }
        }

        return ct;
    }
}