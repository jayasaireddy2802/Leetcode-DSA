class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int f_sum = 0;
        int maxSum = 0;

        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
            f_sum += i * nums[i];
        }

        maxSum = f_sum;

        for(int k = 0; k < len - 1; k++)
        {
            int val = f_sum + sum - len * nums[len - 1 - k];
            maxSum = Math.max(maxSum, val);
            f_sum = val;
        }

        return maxSum;

    }
}