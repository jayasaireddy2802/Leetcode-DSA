class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int[][] ans = new int[len/3][3];
        for(int i = 0; i < len - 2; i = i + 3)
        {
            if(nums[i+2] - nums[i] > k)
                return new int[0][];
        }

        int j = 0;
        int k1 = 0;
        for(int i = 0; i < len/3; i++)
        {
            while(j < 3)
            {
                ans[i][j] = nums[k1];
                j++;
                k1++;
            }
            j = 0;
        }
        return ans;
    }
}