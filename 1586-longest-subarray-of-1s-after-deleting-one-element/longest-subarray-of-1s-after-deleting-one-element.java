// class Solution {
//     public int longestSubarray(int[] nums) {
//         int len = nums.length;
//         int ans = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 int ct = 0;
//                 int one = 1;
//                 for(int k = i; k <= j; k++)
//                 {
//                     if(nums[k] == 1)
//                         ct++;
//                     else if(nums[k] == 0 && one == 1)
//                     {
//                         // ct++;
//                         one = 0;
//                     }
//                     else
//                         break;
//                 }
//                 ans = Math.max(ans, ct);
//             }
//         }
//         if(ans == len)
//             return --ans;
//         return ans;
//     }
// }


// class Solution {
//     public int longestSubarray(int[] nums) {
//         int len = nums.length;
//         int ans = 0;
//         int oneIndex = -1;
//         int i = 0, j = 0;

//         while(j < len)
//         {
//             if(nums[j] == 1)
//                 j++;
//             else if(nums[j] == 0 && oneIndex != -1)
//             {
//                 i = oneIndex + 1;
//             }
//             else if(nums[j] == 0 && oneIndex == -1)
//             {
//                 j++;
//             }

//             ans = Math.max(ans, (j - i));
//         }
//         if(ans == len)
//             return --ans;
//         return ans;
//     }
// }


class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // subtract 1 because we must delete one element
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
