class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int mod = 1000000007;

        for(int[] point : points)
        {
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        int prevEdges = 0;

        for(int key : map.keySet())
        {
            long curr = map.get(key);
            long edges = (curr*(curr - 1))/2;
            ans = (ans + (edges*prevEdges)) % mod;
            prevEdges += edges;

        }

        return(int) ans;
    }
}