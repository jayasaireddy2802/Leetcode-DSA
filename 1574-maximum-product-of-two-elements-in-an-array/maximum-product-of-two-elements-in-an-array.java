// class Solution {
//     public int maxProduct(int[] nums) {
//         int len = nums.length;

//         Arrays.sort(nums);
//         return (nums[len - 1] - 1) * (nums[len - 2] - 1);
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] > firstMax)
            {
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] > secondMax)
            {
                secondMax = nums[i];
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
}