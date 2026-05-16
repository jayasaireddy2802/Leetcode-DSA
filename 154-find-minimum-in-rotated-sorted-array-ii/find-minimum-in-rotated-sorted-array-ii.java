class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mini = Integer.MAX_VALUE;

        while(low <= high)
        {
            while(low < high && nums[low] == nums[low + 1]) 
                low++;
            while(high > low && nums[high] == nums[high - 1])
                high--;

            int mid = low + (high - low) / 2;

            mini = Math.min(mini, nums[mid]);
            if(nums[mid] > nums[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }

        }

        return mini;
    }
}