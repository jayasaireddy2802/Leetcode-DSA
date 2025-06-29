// class Solution {
//     int mod = 1000000007;
//     int res;

//     public void generateSubsequences(int idx, int[] nums, int target, int mini, int maxi)
//     {
//         if(idx >= nums.length)
//         {
//             if(mini + maxi <= target)
//                 res = (res + 1) % mod;
            
//             return ;
//         }

//         generateSubsequences(idx + 1, nums, target, Math.min(mini, nums[idx]), Math.max(maxi, nums[idx]));
//         generateSubsequences(idx + 1, nums, target, mini, maxi);
//     }

//     public int numSubseq(int[] nums, int target) {
//         res = 0;
//         generateSubsequences(0, nums, target, Integer.MAX_VALUE, Integer.MIN_VALUE);
//         res--;
//         return res;
//     }
// }

import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        int i = 0, j = n - 1;
        int ans = 0;

        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                ans = (ans + pow2[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
