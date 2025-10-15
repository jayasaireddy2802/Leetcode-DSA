// class Solution {

//     public boolean isIncreasing(int start, int end, List<Integer> nums)
//     {
//         for(int i = start + 1; i <= end; i++)
//         {
//             if(nums.get(i - 1) >= nums.get(i))
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int maxIncreasingSubarrays(List<Integer> nums) {
        
//         int len = nums.size();

//         for(int k = len - 1; k >= 0; k--)
//         {
//             for(int i = 0; i + 2*k - 1 < len; i++)
//             {
//                 if(isIncreasing(i, i + k - 1, nums) && isIncreasing(i + k, i + 2*k - 1, nums))
//                 {
//                     return k;
//                 }
//             }
//         }

//         return 0;
//     }
// }


// class Solution {

//     public boolean isIncreasing(int start, int end, List<Integer> nums)
//     {
//         for(int i = start + 1; i <= end; i++)
//         {
//             if(nums.get(i - 1) >= nums.get(i))
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int maxIncreasingSubarrays(List<Integer> nums) {
        
//         int len = nums.size();

//         for(int k = len/2; k >= 0; k--)
//         {
//             for(int i = 0; i + 2*k - 1 < len; i++)
//             {
//                 if(isIncreasing(i, i + k - 1, nums) && isIncreasing(i + k, i + 2*k - 1, nums))
//                 {
//                     return k;
//                 }
//             }
//         }

//         return 0;
//     }
// }



// class Solution {

//     public boolean isIncreasing(int start, int end, List<Integer> nums)
//     {
//         for(int i = start + 1; i <= end; i++)
//         {
//             if(nums.get(i - 1) >= nums.get(i))
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int maxIncreasingSubarrays(List<Integer> nums) {
        
//         int len = nums.size();
//         int ans = 0;
//         int i = 0, j = len/2;
//         while(i <= j)
//         {
//             int k = (i+j)/2;
//             boolean possible = false;

//             for(int idx = 0; idx + 2*k - 1 < len; idx++)
//             {
//                 if(isIncreasing(idx, idx + k - 1, nums) && isIncreasing(idx + k, idx + 2*k - 1, nums))
//                 {
//                     possible = true;
//                 }
//             }

//             if(possible)
//             {
//                 ans = k;
//                 i = k + 1;
//             }

//             else
//             {
//                 j = k - 1;
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        
        int len = nums.size();
        int prevLength = -1, currLength = 1;
        int ans = -1;

        for(int i = 1; i < len; i++)
        {
            if(nums.get(i) > nums.get(i-1))
            {
                currLength++;
            }
            else
            {
                ans = Math.max(ans, currLength/2);
                ans = Math.max(ans, Math.min(prevLength, currLength));
                prevLength = currLength;
                currLength = 1;
            }
        }

        ans = Math.max(ans, currLength/2);
        ans = Math.max(ans, Math.min(prevLength, currLength));
        return ans;
    }
}