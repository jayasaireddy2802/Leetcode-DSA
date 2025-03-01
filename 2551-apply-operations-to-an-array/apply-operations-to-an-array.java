// class Solution {
//     public int[] applyOperations(int[] nums) {
//         int len = nums.length;

//         for(int i = 0; i < len-1; i++)
//         {
//             if(nums[i] == nums[i+1])
//             {
//                 nums[i] = nums[i]*2;
//                 nums[i+1] = 0;
//             }
//         }

//         int[] arr = new int[len];
//         int j = 0;
//         for(int i = 0; i < len; i++)
//         {
//             if(nums[i] != 0)
//             {
//                 arr[j] = nums[i];
//                 j++;
//             }
//         }
        
//         while(j < len)
//         {
//             arr[j] = 0;
//             j++;
//         }

//         return arr;
//     }
// }


// class Solution {
//     public int[] applyOperations(int[] nums) {
//         int len = nums.length;

//         for(int i = 0; i < len-1; i++)
//         {
//             if(nums[i] == nums[i+1])
//             {
//                 nums[i] = nums[i]*2;
//                 nums[i+1] = 0;
//             }
//         }

//        int idx = 0;
//        for(int i = 0; i < len; i++)
//        {
//             if(nums[i] != 0)
//             {
//                 nums[idx] = nums[i];
//                 idx++;
//             }
//        }

//         while(idx < len)
//         {
//             nums[idx] = 0;
//             idx++;
//         }

//         return nums;
//     }
// }

class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;

       int idx = 0;
       int i = 0;
        for( i = 0; i < len-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }

            if(nums[i] != 0)
            {
                nums[idx] = nums[i];
                idx++;
            }
        }
         if(nums[i] != 0)
         {
            nums[idx] = nums[i];
            idx++;
        }

        while(idx < len)
        {
            nums[idx] = 0;
            idx++;
        }

        return nums;
    }
}