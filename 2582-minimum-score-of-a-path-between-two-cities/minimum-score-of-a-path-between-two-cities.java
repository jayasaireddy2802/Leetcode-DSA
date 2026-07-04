class Solution {
    int[] parent;
    int[] rank;

    public int findParent(int x)
    {
        if(x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public int minScore(int n, int[][] roads) {
        int mini = Integer.MAX_VALUE;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 0; i <= n; i++)
            parent[i] = i;

        for(int[] road : roads)
        {
            int u = road[0];
            int v = road[1];
            int ult_u = findParent(u);
            int ult_v = findParent(v);

            if(ult_u == ult_v) continue;

            if(rank[ult_u] >= rank[ult_v])
            {
                parent[ult_v] = ult_u;
                rank[ult_u]++;
            }
            else
            {
                parent[ult_u] = ult_v;
                rank[ult_v]++;
            }
        }

        int parent1 = findParent(1);
        if(parent1 != findParent(n))
        {
            return -1;
        }


        for(int[] road : roads)
        {
            int u = road[0];
            int v = road[1];
            int dis = road[2];

            if(findParent(u) == parent1)
                mini = Math.min(dis, mini);
        }
        

        return mini;
    }
}