class Solution {

    public boolean isPossible(int p, int q, int[] nums)
    {
        int len = nums.length;

        for(int i = 0; i < p; i++)
        {
            if(nums[i] >= nums[i + 1])
                return false;
        }

        for(int i = p; i < q; i++)
        {
            if(nums[i] <= nums[i + 1])
                return false;
        }

        for(int i = q; i < len - 1; i++)
        {
            if(nums[i] >= nums[i + 1])
                return false;
        }

        return true;
    }
    public boolean isTrionic(int[] nums) {
        int len = nums.length;

        for(int i = 1; i < len - 2; i++)
        {
            for(int j = i + 1; j < len - 1; j++)
            {
                if(isPossible(i, j, nums))
                {
                    return true;
                }
            }
        }

        return false;
    }
}