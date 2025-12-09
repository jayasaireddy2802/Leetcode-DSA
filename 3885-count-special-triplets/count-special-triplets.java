// class Solution {
//     public int specialTriplets(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i + 1; j < len; j++)
//             {
//                 for(int k = j + 1; k < len; k++)
//                 {
//                     if(nums[i] == nums[j]*2 && nums[k] == nums[j]*2)
//                         ct++;
//                 }
//             }
//         }

//         return ct;
//     }
// }


// class Solution {
//     public int specialTriplets(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i + 1; j < len; j++)
//             {
//                 for(int k = j + 1; k < len; k++)
//                 {
//                     if(nums[i] == nums[k] && nums[k] == nums[j]*2)
//                         ct++;
//                 }
//             }
//         }

//         return ct;
//     }
// }




// class Solution {
//     public int specialTriplets(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             int num = 2*nums[i];
//             int ctPrev = 0;
//             int ctNext = 0;
//             int j = i - 1;
//             int k = i + 1;
//             while(j >= 0)
//             {
//                 if(nums[j] == num)
//                     ctPrev++;
//                 j--;
//             }
//             while(k < len)
//             {
//                 if(nums[k] == num)
//                     ctNext++;
//                 k++;
//             }
//             // ct += Math.min(ctPrev, ctNext);

//             ct += ctPrev*ctNext;
//         }

//         return ct;
//     }
// }




// class Solution {
//     public int specialTriplets(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             int num = 2*nums[i];
//             int ctPrev = 0;
//             int ctNext = 0;
//             int j = i - 1;
//             int k = i + 1;
//             while(j >= 0)
//             {
//                 if(nums[j] == num)
//                     ctPrev++;
//                 j--;
//             }
//             while(k < len)
//             {
//                 if(nums[k] == num)
//                     ctNext++;
//                 k++;
//             }
//             // ct += Math.min(ctPrev, ctNext);

//             ct += ctPrev*ctNext;
//         }

//         return ct;
//     }
// }




// class Solution {
//     public int specialTriplets(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             int num = 2*nums[i];
//             int ctPrev = 0;
//             int ctNext = 0;
//             int j = i - 1;
//             int k = i + 1;
//             while(j >= 0)
//             {
//                 if(nums[j] == num)
//                     ctPrev++;
//                 j--;
//             }
//             while(k < len)
//             {
//                 if(nums[k] == num)
//                     ctNext++;
//                 k++;
//             }
//             // ct += Math.min(ctPrev, ctNext);

//             ct += ctPrev*ctNext;
//         }

//         return ct;
//     }
// }






class Solution {
    public int specialTriplets(int[] nums) {
        int len = nums.length;
        long ct = 0;
        int mod = 1000000007;
        int MAX = 2000005;
        int[] ctPrev = new int[MAX];
        int[] ctNext = new int[MAX];

        for(int num : nums)
            ctNext[num]++;

        for(int i = 0; i < len; i++)
        {
            
            ctNext[nums[i]]--;

            int num = 2*nums[i];
            int ct1 = ctPrev[num];
            int ct2 = ctNext[num];
            
            // ct += Math.min(ctPrev, ctNext);

            ct = (ct + (long)ct1*ct2) % mod;

            ctPrev[nums[i]]++;
        }

        return (int)ct;
    }
}


