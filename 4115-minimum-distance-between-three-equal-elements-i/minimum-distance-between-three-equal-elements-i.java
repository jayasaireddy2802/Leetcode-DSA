class Solution {
    public int minimumDistance(int[] nums) {
        int len = nums.length;
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                for(int k = j + 1; k < len; k++)
                {
                    if(nums[i] == nums[j] && nums[j] == nums[k])
                    {
                        int val = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        mini = Math.min(val, mini);
                    }
                }
            }
        }

        return (mini == Integer.MAX_VALUE) ? -1 : mini;
    }
}