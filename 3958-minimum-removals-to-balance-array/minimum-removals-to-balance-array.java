class Solution {
    public int minRemoval(int[] nums, int k) {
        int len = nums.length;
        int mini = len;
        Arrays.sort(nums);

        int j = 0;
        for(int i = 0; i < len; i++)
        {
            while(j < len && (long)nums[j] <= (long)nums[i] * k)
                j++;
            mini = Math.min(mini, len - (j - i));
        }

        return mini;
    }
}