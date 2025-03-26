class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m*n;
        int i = 0;
        int[] nums = new int[m*n];
        for(int[] arr : grid)
        {
            for(int num : arr)
            {
                nums[i] = num;
                i++;
            }
        }

        Arrays.sort(nums);

        int mid = len / 2;
        int target = nums[mid];
        int result = 0;
        for(i = 0; i < len; i++)
        {
            if(target%x != nums[i]%x)
                return -1;
            result = result + Math.abs(target - nums[i])/x;
        }

        return result;
    }
}