class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int nodes = colors.length();
        int[] indegree = new int[nodes];
        Queue<Integer> queue = new LinkedList<>();
        int ct = 0;
        int[][] dp = new int[nodes][26];
        int ans = 0;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nodes; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            indegree[v]++;
        }

        for(int i = 0; i < nodes; i++)
        {
            if(indegree[i] == 0){
                queue.add(i);
                dp[i][colors.charAt(i) - 'a']++;
            }
        }

        // topo sort

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            ct++;
            ans = Math.max(ans, dp[node][colors.charAt(node) - 'a']);

            for(int neighbour : list.get(node))
            {
                for(int j = 0; j < 26; j++)
                {
                    int val = 0;
                    if(colors.charAt(neighbour) - 'a' == j)
                        val++;
                    dp[neighbour][j] = Math.max(dp[neighbour][j], dp[node][j] + val);
                }

                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        if(ct < nodes)
            return -1;
        return ans;

    }
}