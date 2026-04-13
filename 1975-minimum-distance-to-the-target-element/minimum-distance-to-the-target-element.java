class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int mini = Integer.MAX_VALUE;
        int len = nums.length;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] == target)
            {
                mini = Math.min(mini, Math.abs(i - start));
            }
        }

        return mini;
    }
}