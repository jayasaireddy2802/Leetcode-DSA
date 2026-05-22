// // class Solution {
// //     public int findMin(int[] nums) {
// //         int min = Integer.MAX_VALUE;

// //         for(int num : nums)
// //             min = Math.min(min, num);
        
// //         return min;
// //     }
// // }


// class Solution {
//     public int findMin(int[] nums) {
//         int len = nums.length;
//         int low = 0;
//         int high = len - 1;
//         int min = Integer.MAX_VALUE;

//         while(low <= high)
//         {
//             int mid = low + (high - low)/2;

//             if(nums[mid] >= nums[high])
//             {
//                 min = nums[low];
//                 low = mid + 1;
//             }
//             else
//             {
//                 high = mid;
//             }
//         }

//         return min;
//     }
// }


// class Solution {
//     public int findMin(int[] nums) {
//         int min = Integer.MAX_VALUE;

//         for(int num : nums)
//             min = Math.min(min, num);
        
//         return min;
//     }
// }


class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int min = Integer.MAX_VALUE;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(nums[low] <= nums[mid])
            {
                min = Math.min(nums[low],min);
                low = mid + 1;
            }
            else
            {
                min = Math.min(nums[mid],min);
                high = mid - 1;
            }
        }

        return min;
    }
}