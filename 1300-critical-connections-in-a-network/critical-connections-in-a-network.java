class Solution {

    List<List<Integer>> adj;
    int[] time;
    int[] lowTime;
    boolean[] visited;
    List<List<Integer>> bridges;

    public void dfs(int idx, int parent, int ct)
    {
        visited[idx] = true;
        time[idx] = ++ct;
        lowTime[idx] = ct;

        for(int neighbour : adj.get(idx))
        {

            if(neighbour == parent)
                continue;

            if(!visited[neighbour]){
                dfs(neighbour, idx, ct);
                lowTime[idx] = Math.min(lowTime[idx], lowTime[neighbour]);
                if(time[idx] < lowTime[neighbour])
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(idx);
                    list.add(neighbour);
                    bridges.add(list);
                }
            }

            else
            {
                lowTime[idx] = Math.min(lowTime[idx], lowTime[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        adj = new ArrayList<>();
        time = new int[n];
        lowTime = new int[n];
        visited = new boolean[n];
        bridges = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> connection : connections)
        {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, 1);

        return bridges;
    }
}