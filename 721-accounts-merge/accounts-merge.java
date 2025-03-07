
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
            parent[parent_v] = parent_u;
        else if(rank[parent_u] < rank[parent_v])
            parent[parent_u] = parent_v;
        else
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int size = accounts.get(i).size();
            for(int j = 1; j < size; j++)
            {
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email))
                {
                    map.put(email, i);
                }
                else
                {
                    int u = map.get(email);
                    int v = i;

                    ds.findURank(u, v);
                }
            }
        }

        Map<Integer, List<String>> mergedMap = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            mergedMap.put(i, new ArrayList<>());
        }

        List<String> list;
        for(String email : map.keySet())
        {
            int num = ds.findParent(map.get(email));
            list = mergedMap.get(num);
            list.add(email);
            mergedMap.put(num, list);
        }

        for(int i = 0; i < n; i++)
        {
            if(!mergedMap.get(i).isEmpty())
            {
                list = mergedMap.get(i);
                Collections.sort(list);
                list.add(0, accounts.get(i).get(0));
                ans.add(list);
            }
        }

        return ans;
    }
}