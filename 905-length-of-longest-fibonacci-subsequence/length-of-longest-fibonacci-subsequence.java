class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            map.put(arr[i], i);
            for(int j = i + 1; j < n; j++)
            {
               dp[i][j] = 2;
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int k = arr[i] + arr[j];
                if(map.containsKey(k))
                {
                    int idx = map.get(k);
                    dp[j][idx] = dp[i][j] + 1;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                res = Math.max(res, dp[i][j]);
            }
        }

        return res == 2 ? 0 : res;
    }
}