class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        long[][] distance = new long[26][26];
        int len = original.length;
        long ans = 0;

        for(long[] arr : distance)
            Arrays.fill(arr, 100000000);

        for(int i = 0; i < len; i++)
        {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';

            distance[u][v] = Math.min(distance[u][v], cost[i]);

        }

        for(int k = 0; k < 26; k++)
        {
            for(int i = 0; i < 26; i++)
            {
                for(int j = 0; j < 26; j++)
                {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }


        for(int i = 0; i < source.length(); i++)
        {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if(u == v) continue;

            if (distance[u][v] >= 100000000) return -1;

            ans += distance[u][v];
        }

        return (ans == 100000000) ? -1 : ans;
    }
}