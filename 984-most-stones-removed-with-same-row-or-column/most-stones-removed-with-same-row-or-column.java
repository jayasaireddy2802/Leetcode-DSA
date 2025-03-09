class DisjointSet
{
    int[] parent;
    int[] rank;

    public DisjointSet(int V)
    {
        rank = new int[V];
        parent = new int[V];
        for(int i = 0; i < V; i++)
            parent[i] = i;
    }

    public int findParent(int x)
    {
        if(parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void unionByRank(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);
        if(parent_u == parent_v)
            return ;
        if(rank[parent_u] > rank[parent_v])
            parent[parent_v] = parent_u;
        if(rank[parent_u] < rank[parent_v])
            parent[parent_u] = parent_v;
        if(rank[parent_u] == rank[parent_v])
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int rowMax = 0;
        int colMax = 0;
        int l = stones.length;
        for(int[] stone : stones)
        {
            int i = stone[0];
            int j = stone[1];
            rowMax = Math.max(rowMax, i);
            colMax = Math.max(colMax, j);           
        }
        DisjointSet ds = new DisjointSet(rowMax + colMax + 2);
        for(int[] stone : stones)
        {
            int i = stone[0];
            int j = stone[1];

            if(ds.findParent(i) != ds.findParent(rowMax + 1 + j))
            {
                ds.unionByRank(i, rowMax + 1 + j);
            }
        }

        Set<Integer> uniqueParents = new HashSet<>();
       
        for (int[] stone : stones) {
            uniqueParents.add(ds.findParent(stone[0]));
            uniqueParents.add(ds.findParent(rowMax + 1 + stone[1]));
        }
        int ct = uniqueParents.size();

        return l - ct;
    }
}