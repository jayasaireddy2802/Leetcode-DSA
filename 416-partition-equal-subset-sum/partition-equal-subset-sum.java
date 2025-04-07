// class Solution {

//     public boolean solve(int idx, int sum, int[] nums)
//     {
//         if(idx > nums.length)
//             return false;
//         if(idx == nums.length)
//         {
//             return (sum == 0);                
//         }

//         return solve(idx+1, sum - nums[idx], nums) || solve(idx+1, sum, nums);
//     }

//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int num : nums)
//             sum += num;
//         if(sum % 2 != 0)
//             return false;
        
//         sum = sum / 2;

//         return solve(0, sum, nums);
        
//     }
// }


class Solution {

    public int solve(int idx, int sum, int[] nums, int[][] dp)
    {
        if(idx > nums.length || sum < 0)
            return 0;

        if(idx == nums.length)
        {
            if (sum == 0)
                return 1;
            else
                return 0;                
        }

        if(dp[idx][sum] != -1)
            return dp[idx][sum];

        int val1 = solve(idx+1, sum - nums[idx], nums, dp);
        int val2 = solve(idx+1, sum, nums,dp);
        if(val1 == 1 || val2 == 1)
            return dp[idx][sum] = 1;
        else
            return dp[idx][sum] = 0;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        
        sum = sum / 2;

        int[][] dp = new int[nums.length][sum + 1];
        for(int[] arr : dp)
        {
            Arrays.fill(arr, -1);
        }

        int ans = solve(0, sum, nums, dp);
        if(ans == 1)
            return true;
        else
            return false;
        
    }
}