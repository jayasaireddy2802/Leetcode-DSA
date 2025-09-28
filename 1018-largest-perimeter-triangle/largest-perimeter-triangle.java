class Solution {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int i = nums.length - 3;

        while(i >= 0)
        {
            if(nums[i] + nums[i+1] > nums[i+2])
                return nums[i] + nums[i+1] + nums[i+2];
            i--;
        }

        return 0;        
    }
}