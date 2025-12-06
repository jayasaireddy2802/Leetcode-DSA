// class Solution {
//     int ct = 0;
//     int mod = 1000000007;

//     public void partitions(int idx, int k, int[] nums)
//     {
//         int len = nums.length;

//         if(idx == len)
//         {
//             ct = (ct + 1) % mod;
//             return ;
//         }

//         int min = nums[idx];
//         int max = nums[idx];

//         for(int i = idx; i < len; i++)
//         {
//             min = Math.min(min, nums[i]);
//             max = Math.max(max, nums[i]);

//             if(max - min > k)
//                 break;
            
//             partitions(i + 1, k, nums);
//         }
//     }
//     public int countPartitions(int[] nums, int k) {
//         int len = nums.length;
//         ct = 0;

//         partitions(0, k, nums);

//         return ct;
//     }
// }


// class Solution {
//     int ct = 0;
//     int mod = 1000000007;

//     public int partitions(int idx, int k, int[] nums, int[] dp)
//     {
//         int len = nums.length;

//         if(idx == len)
//         {
//             return 1;
//         }

//         if(dp[idx] != -1)
//             return dp[idx];

//         int min = nums[idx];
//         int max = nums[idx];
//         int ways = 0;

//         for(int i = idx; i < len; i++)
//         {
//             min = Math.min(min, nums[i]);
//             max = Math.max(max, nums[i]);

//             if(max - min > k)
//                 break;
            
//             ways = (ways + partitions(i + 1, k, nums, dp)) % mod;
//         }

//         return dp[idx] = ways;
//     }
//     public int countPartitions(int[] nums, int k) {
//         int len = nums.length;

//         int[] dp = new int[len];
//         Arrays.fill(dp, -1);

//         return partitions(0, k, nums, dp);
//     }
// }


class Solution {
    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;       // empty partition
        pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int L = 0;

        for (int i = 0; i < n; i++) {

            // maintain min queue
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[i])
                minQ.pollLast();
            minQ.addLast(i);

            // maintain max queue
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[i])
                maxQ.pollLast();
            maxQ.addLast(i);

            // shrink window until valid
            while (!minQ.isEmpty() && !maxQ.isEmpty() &&
                   nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {

                if (minQ.peekFirst() == L) minQ.pollFirst();
                if (maxQ.peekFirst() == L) maxQ.pollFirst();
                L++;
            }

            // dp[i+1] = sum(dp[L]..dp[i])
            long total = pref[i];
            long subtract = (L > 0 ? pref[L - 1] : 0);

            dp[i + 1] = (total - subtract + MOD) % MOD;
            pref[i + 1] = (pref[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
