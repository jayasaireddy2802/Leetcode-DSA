class Solution {
    public int missingInteger(int[] nums) {
        boolean[] isPresent = new boolean[51];
        int len = nums.length;
        int ct = nums[0];

        for(int num : nums)
            isPresent[num] = true;

        for(int i = 1; i < len; i++)
        {
            if(nums[i] == nums[i - 1] + 1)
            {
                ct = ct + nums[i];
            }
            else
                break;
        }
    
        for(int i = ct; i < 51; i++)
        {
            if(isPresent[i] == true)
                ct++;
            else
                break;
        }

        return ct;

    }
}