class Solution {
    public int countHillValley(int[] nums) {
        int ct = 0;
        int len = nums.length;
        int i = 0, j = 1;

        while(j < len - 1)
        {
            if(nums[j] == nums[j + 1])
            {
                j++;
                continue;
            }

            if(nums[i] < nums[j] && nums[j + 1] < nums[j])
                ct++;
            if(nums[i] > nums[j] && nums[j + 1] > nums[j])
                ct++;
            i = j;
            j++;
        }

        return ct;
    }
}