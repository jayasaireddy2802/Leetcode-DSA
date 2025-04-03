// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         long ans = 0;
//         int len = nums.length;
//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i + 1; j < len; j++)
//             {
//                 for(int k = j + 1; k < len; k++)
//                 {
//                     ans = Math.max(ans, (long)(nums[i] - nums[j])*nums[k]);
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];

        for(int i = 1; i < len; i++)
        {
            leftmax[i] = Math.max(leftmax[i-1], nums[i-1]);
        }

        for(int i = len - 2; i >= 0; i--)
        {
            rightmax[i] = Math.max(rightmax[i+1], nums[i+1]);
        }

        for(int i = 0; i < len; i++)
        {
            ans = Math.max(ans, (long)(leftmax[i]-nums[i])*rightmax[i]);
        }

        return ans;
    }
}