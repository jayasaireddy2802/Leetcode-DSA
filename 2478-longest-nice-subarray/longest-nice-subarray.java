// class Solution {

//     public boolean isPossible(int i, int j, int[] nums)
//     {
//         for(int x = i; x <= j; x++)
//         {
//             for(int y = x + 1; y <= j; y++)
//             {
//                 if((nums[x] & nums[y]) != 0)
//                     return false;
//             }
//         }

//         return true;
//     }

//     public int longestNiceSubarray(int[] nums) {
        
//         int len = nums.length;
//         int maxLength = 0;
//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if(isPossible(i, j, nums))
//                 {
//                     maxLength = Math.max(maxLength, (j - i + 1));
//                 }
//             }
//         }

//         return maxLength;
//     }
// }



class Solution {

    public boolean isPossible(int i, int j, int[] nums)
    {
        for(int x = i; x <= j; x++)
        {
            for(int y = x + 1; y <= j; y++)
            {
                if((nums[x] & nums[y]) != 0)
                    return false;
            }
        }

        return true;
    }

    public int longestNiceSubarray(int[] nums) {
        
        int len = nums.length;
        int maxLength = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = i; j < len; j++)
            {
                if(isPossible(i, j, nums))
                {
                    maxLength = Math.max(maxLength, (j - i + 1));
                }
                else
                    break;
            }
        }

        return maxLength;
    }
}