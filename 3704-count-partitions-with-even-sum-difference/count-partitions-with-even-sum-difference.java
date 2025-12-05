class Solution {
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int len = nums.length;
        int ct = 0;

        for(int num : nums)
            rightSum += num;

        for(int i = 0; i < len - 1; i++)
        {
            leftSum += nums[i];
            rightSum -= nums[i];

            if((leftSum - rightSum) % 2 == 0)
                ct++;            
        }

        return ct;
    }
}