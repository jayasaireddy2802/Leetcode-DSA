// class Solution {

//     public void dfs(int i, boolean[] visited, int[][] isConnected)
//     {
//         visited[i] = true;
//         int n = isConnected.length;
//         for(int j = 0; j < n; j++)
//         {
//             if(isConnected[i][j] == 1 && !visited[j])
//                 dfs(j, visited, isConnected);
//         }

//     }

//     public int findCircleNum(int[][] isConnected) {
//         int r = isConnected.length;
//         int c = isConnected[0].length;
//         boolean[] visited = new boolean[r];
//         int ans = 0;
//         for(int i = 0; i < r; i++)
//         {
//             if(!visited[i])
//             {
//                 dfs(i, visited, isConnected);
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }


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
        if(rank[parent_u] > rank[parent_v])
        {
            parent[parent_v] = parent_u;
        }
        else if(rank[parent_u] < rank[parent_v])
        {
            parent[parent_u] = parent_v;
        }
        else
        {
            parent[parent_v] = parent_u;
            rank[parent_v]++;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        DisjointSet ds = new DisjointSet(V);

        for(int i = 0;i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                if(isConnected[i][j] == 1)
                    ds.findURank(i, j);
            }
        }

        int ct = 0;
        for(int i = 0; i < V; i++)
        {
            if(ds.parent[i] == i)
                ct++;
        }

        return ct;
    }
}