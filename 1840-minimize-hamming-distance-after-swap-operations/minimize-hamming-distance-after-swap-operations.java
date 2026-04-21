class Solution {
    int[] parent;
    int[] rank;

    public int findParent(int x)
    {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y)
    {
        int parent_x = findParent(x);
        int parent_y = findParent(y);
        if(parent_x == parent_y) return ;
        if(rank[parent_x] >= rank[parent_y])
        {
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
        else 
        {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int len = source.length;
        parent = new int[len];
        rank = new int[len];

        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }

        for(int[] arr : allowedSwaps)
        {
            union(arr[0], arr[1]);
        }

        Map<Integer, Map<Integer, Integer>> groupMap = new HashMap<>();

        for(int i = 0; i < len; i++)
        {
            int root = findParent(i);

            groupMap.computeIfAbsent(root, k -> new HashMap<>());
            Map<Integer, Integer> freqMap = groupMap.get(root);
            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
            groupMap.put(root, freqMap);

        }

        int dis =0;
        for(int i = 0; i < len; i++)
        {
            int root = findParent(i);
            Map<Integer, Integer> freq = groupMap.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                dis++;
            }
        }

        return dis;
    }
}