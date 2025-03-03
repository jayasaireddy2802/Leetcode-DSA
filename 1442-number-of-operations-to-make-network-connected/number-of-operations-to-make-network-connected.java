
class DisjointSet
{
    int[] parent;
    int[] rank;
    public DisjointSet(int V)
    {
        rank = new int[V];
        parent = new int[V];

        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
        }
    }

    public int findParent(int x)
    {
        if(parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void findURank(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u == parent_v)
            return ;
        if(rank[parent_u] >= rank[parent_v])
        {
            parent[parent_v] = parent_u;
        }
        else
        {
            parent[parent_u] = parent_v;
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int V = connections.length;
        DisjointSet ds = new DisjointSet(n);
        int ct = 0;
        int components = 0;

        for(int[] arr : connections)
        {
            if(ds.findParent(arr[0]) == ds.findParent(arr[1]))
                ct++;
            else
                ds.findURank(arr[0], arr[1]);
        }
        

        for(int i = 0; i < n; i++)
        {
            if(ds.parent[i] == i)
            {
                components++;   
            }
        }

        if(components - 1 <= ct)
            return components-1;
        return -1;
    }
}