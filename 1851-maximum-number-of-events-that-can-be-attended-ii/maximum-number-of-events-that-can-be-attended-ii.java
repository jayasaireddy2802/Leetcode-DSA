// class Solution {
//     public int solve(int idx, int[][] events, int k)
//     {
//         int len = events.length;

//         if(k == 0)
//             return 0;

//         if(idx >= len)
//             return 0;        

//         int notTake = 0 + solve(idx + 1, events, k);
       
//         int j;
//         for(j = idx + 1; j < len; j++)
//         {
//             if(events[j][0] > events[idx][1])
//                 break;
//         }
//         int take = events[idx][2] + solve(j , events, k-1);

//         return Math.max(notTake, take);
//     }
//     public int maxValue(int[][] events, int k) {
//         Arrays.sort(events, (a, b) -> (a[0] - b[0]));
//         return solve(0, events, k);
//     }
// }


class Solution {
    int[][] dp;

    public int solve(int idx, int[][] events, int k) {
        if (idx == events.length || k == 0) return 0;
        if (dp[idx][k] != -1) return dp[idx][k];

        // Skip current event
        int notTake = solve(idx + 1, events, k);

        // Take current event
        int nextIdx = binarySearch(events, events[idx][1]);
        int take = events[idx][2] + solve(nextIdx, events, k - 1);

        return dp[idx][k] = Math.max(notTake, take);
    }

    // Binary search to find the next non-overlapping event
    public int binarySearch(int[][] events, int endTime) {
        int low = 0, high = events.length - 1;
        int ans = events.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > endTime) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        dp = new int[events.length][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, events, k);
    }
}
