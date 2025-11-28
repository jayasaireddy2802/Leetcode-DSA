class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if(n == 1)
            return 1;
        int comp = 0;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = values[i];
        }

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 1)
                queue.add(i);
        }

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            long addValue = arr[node] % k == 0 ? 0 : arr[node];

            if(addValue == 0)
                comp++;
                

            for(int neighbour : adj.get(node))
            {
                if(indegree[neighbour] > 0)
                {
                    indegree[neighbour]--;
                    arr[neighbour] = arr[neighbour] + addValue;
                    if(indegree[neighbour] == 1)
                        queue.add(neighbour);
                }
            }
        }

        return comp;
    }
}
