class Solution {

    public boolean isIncreasing(int start, int end, List<Integer> nums) {
        
        for (int i = start + 1; i <= end; i++) {
            if (nums.get(i) <= nums.get(i - 1))  
                return false;
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int len = nums.size();

        for (int i = 0; i + 2 * k - 1 < len; i++) {
            if (isIncreasing(i, i + k - 1, nums) && isIncreasing(i + k, i + k + k - 1, nums)) {
                return true;
            }
        }

        return false;
    }
}
