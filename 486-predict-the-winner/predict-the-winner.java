class Solution {

    public boolean solve(int s1, int s2, int i, int j, int turn, int[] nums)
    {
        if(i > j)
            return s1 >= s2;

        if (turn == 1) {
            
            return solve(s1 + nums[i], s2, i + 1, j, 2, nums) ||
                   solve(s1 + nums[j], s2, i, j - 1, 2, nums);
        } else {
            
            return solve(s1, s2 + nums[i], i + 1, j, 1, nums) &&
                   solve(s1, s2 + nums[j], i, j - 1, 1, nums);
        }
        
    }

    public boolean predictTheWinner(int[] nums) {

        return solve(0, 0, 0, nums.length - 1, 1, nums);
        
    }
}