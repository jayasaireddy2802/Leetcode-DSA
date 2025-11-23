// class Solution {
//     int ans;
//     public void greatestSum(int idx, int sum, int[] nums)
//     {
//         if(sum % 3 == 0)
//             ans = Math.max(ans, sum);

//         if(idx >= nums.length)
//             return ;
        
//         greatestSum(idx + 1, sum + nums[idx], nums);
//         greatestSum(idx + 1, sum, nums);
//     }

//     public int maxSumDivThree(int[] nums) {
//         ans = 0;
//         greatestSum(0, 0, nums);
//         return ans;
//     }
// }
class Solution {
    int ans;

    public void greatestSum(int idx, int sum, int[] nums, int[][] dp) {
        if (idx >= nums.length) {
            if (sum % 3 == 0) {
                ans = Math.max(ans, sum);
            }
            return;
        }

        int rem = sum % 3;

        // If already visited this state with better or same sum, skip
        if (dp[idx][rem] >= sum) return;

        dp[idx][rem] = sum;

        // Include current number
        greatestSum(idx + 1, sum + nums[idx], nums, dp);

        // Exclude current number
        greatestSum(idx + 1, sum, nums, dp);
    }

    public int maxSumDivThree(int[] nums) {
        ans = 0;
        // DP table: dp[idx][rem] = maximum sum achieved at index idx with remainder rem
        int[][] dp = new int[nums.length][3];
        for (int[] row : dp) Arrays.fill(row, -1);

        greatestSum(0, 0, nums, dp);
        return ans;
    }
}
