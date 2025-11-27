// class Solution {
//     public long maxSubarraySum(int[] nums, int k1) {
//         int len = nums.length;
//         long ans = Integer.MIN_VALUE;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if((j - i + 1 ) % k1 == 0)
//                 {
//                     long sum = 0;
//                     for(int k = i; k <= j; k++)
//                     {
//                         sum = sum + nums[k];
//                     }
//                     ans = Math.max(sum, ans);
//                 }
//             }
//         }

//         return ans;
//     }
// }



// class Solution {
//     public long maxSubarraySum(int[] nums, int k1) {
//         int len = nums.length;
//         long ans = Integer.MIN_VALUE;
//         long[] prefix = new long[len + 1];

//         for(int i = 1; i <= len; i++)
//             prefix[i] = prefix[i-1] + nums[i-1];

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if((j - i + 1 ) % k1 == 0)
//                 {
//                     long sum = prefix[j+1] - prefix[i];
                    
//                     ans = Math.max(sum, ans);
//                 }
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public long maxSubarraySum(int[] nums, int k1) {
        int len = nums.length;
        long ans = Long.MIN_VALUE;
        long[] prefix = new long[len + 1];

        for(int i = 1; i <= len; i++)
            prefix[i] = prefix[i-1] + nums[i-1];

        for(int start = 0; start < k1; start++)
        {
            long currSum = 0;
            int i = start;

            while(i < len && (i + k1 - 1) < len)
            {
                int j = i + k1 - 1;
                long sum = prefix[j + 1] - prefix[i];

                currSum = Math.max(sum, sum + currSum);
                ans = Math.max(ans, currSum);

                i = i + k1;
            }
        }

        return ans;
    }
}