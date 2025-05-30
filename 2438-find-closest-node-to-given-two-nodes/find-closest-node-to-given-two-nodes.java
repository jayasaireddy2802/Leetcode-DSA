class Solution {

    public void dfs(int i, int[] edges, boolean[] visited, int[] dist)
    {
        visited[i] = true;

        int neighbour = edges[i];
        if(neighbour != -1 && !visited[neighbour]){
            dist[neighbour] = dist[i] + 1;
            dfs(neighbour, edges, visited, dist);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] visited;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        int ans = -1;
        int min_dist = Integer.MAX_VALUE;

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        visited = new boolean[n];
        dist1[node1] = 0;
        dfs(node1, edges, visited, dist1);
        visited = new boolean[n];
        dist2[node2] = 0;
        dfs(node2, edges, visited, dist2);

        for(int i = 0; i < n; i++)
        {
            int val = Math.max(dist1[i], dist2[i]);
            if(val < min_dist)
            {
                min_dist = val;
                ans = i;
            }
        }

        return ans;
    }
} 