// class Solution {
//     public long zeroFilledSubarray(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 boolean check = true;
//                 for(int k = i; k <= j; k++)
//                 {
//                     if(nums[k] != 0)
//                     {
//                         check = false; 
//                         break;
//                     }
//                 }
//                 if(check)
//                     ct++;
//             }
//         }

//         return ct;
//     }
// }


// class Solution {
//     public long zeroFilledSubarray(int[] nums) {
//         int len = nums.length;
//         long ct = 0;
//         long ans = 0;

//         for(int i = 0; i < len; i++)
//         {
//             if(nums[i] == 0)
//                 ct++;
//             else
//             {
//                 ans += (ct*(ct+1))/2;
//                 ct = 0;
//             }
//         }
//         ans += (ct*(ct+1))/2;

//         return ans;

//     }
// }

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int len = nums.length;
        long ct = 0;
        long ans = 0;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 0)
            {
                ct++;
                ans += ct;
            }
            else
            {
                ct = 0;
            }
        }

        return ans;

    }
}