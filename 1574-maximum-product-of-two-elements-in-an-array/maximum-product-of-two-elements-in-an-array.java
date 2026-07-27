class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}