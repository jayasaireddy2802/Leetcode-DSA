
class DisjointSet
{
    int[] parent;
    int[] rank;
    int[] cost;

    public DisjointSet(int V)
    {
        rank = new int[V];
        parent = new int[V];
        cost = new int[V];

        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
            cost[i] = Integer.MAX_VALUE;
        }

       
    }

    public int findParent(int x)
    {
        if(parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void unionByRank(int u, int v, int wt)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u == parent_v)
            return ;
        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
            cost[parent_u] = cost[parent_u] & cost[parent_v];
        }
        else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
            cost[parent_v] = cost[parent_v] & cost[parent_u];
        }
        else
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
            cost[parent_u] = cost[parent_u] & cost[parent_v];
        }
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        int len = query.length;
        int[] ans = new int[len];
        int i = 0;
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            int parent_v = ds.findParent(v);
            int parent_u = ds.findParent(u);

            if(parent_u != parent_v)
            {
                ds.unionByRank(u, v, wt);
            }  

            parent_u = ds.findParent(u);
            ds.cost[parent_u] = ds.cost[parent_u] & wt;        
        }

        for(int x : ds.cost)
        {
            System.out.print(x + " ");
        }

        for(int[] q : query)
        {
            int parent_s = ds.findParent(q[0]);
            int parent_t = ds.findParent(q[1]);

            if(q[0] == q[1])
                ans[i] = 0;
            else if(parent_s != parent_t)
                ans[i] = -1;
            else
                ans[i] = ds.cost[parent_s];
            
            i++;
        }

        return ans;
    }
}