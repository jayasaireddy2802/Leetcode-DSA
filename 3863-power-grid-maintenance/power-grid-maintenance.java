class Solution {
    int[] parent;

    public void dfs(int i, int comp, boolean[] visited, List<List<Integer>> adj)
    {
        parent[i] = comp;
        visited[i] = true;

        for(int neighbour : adj.get(i))
        {
            if(!visited[neighbour])
                dfs(neighbour, comp, visited, adj);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= c; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] connection : connections)
        {
            int x = connection[0];
            int y = connection[1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] visited = new boolean[c + 1];
        int comp = 1;

        for(int i = 1; i <= c; i++)
        {
            if(!visited[i])
            {
                dfs(i, comp, visited, adj);
                comp++;
            }
            
        }

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for(int i = 1; i <= c; i++)
        {
            TreeSet<Integer> set = map.get(parent[i]);
            if(!map.containsKey(parent[i]))
            {
                set = new TreeSet<>();
            }
            set.add(i);
            map.put(parent[i], set);
        }

        boolean[] offline = new boolean[c+ 1];
        List<Integer> list = new ArrayList<>();

        for(int[] query : queries)
        {
            int res1 = query[0];
            int res2 = query[1];

            if(res1 == 1)
            {
                if(offline[res2])
                {
                    TreeSet<Integer> set = map.get(parent[res2]);
                    if(set == null || set.isEmpty())
                        list.add(-1);
                    else
                        list.add(set.first());
                }
                else
                    list.add(res2);
            }
            else
            {
                offline[res2] = true;
                map.get(parent[res2]).remove(res2);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}