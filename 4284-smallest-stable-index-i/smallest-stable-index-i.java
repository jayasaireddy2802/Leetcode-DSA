// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int len = nums.length;
//         int[] max = new int[len];
//         int[] min = new int[len];
//         int maxi = Integer.MIN_VALUE;
//         int mini = Integer.MAX_VALUE;

//         for(int i = 0; i < len; i++)
//         {
//             maxi = Math.max(maxi, nums[i]);
//             max[i] = maxi;
//         }

//         for(int i = len - 1; i >= 0; i--)
//         {
//             mini = Math.min(mini, nums[i]);
//             min[i] = mini;
//         }

//         for(int i = 0; i < len; i++)
//         {
//             if(max[i] - min[i] <= k) 
//                 return i;
//         }

//         return -1;
//     }
// }


class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        int[] min = new int[len];
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for(int i = len - 1; i >= 0; i--)
        {
            mini = Math.min(mini, nums[i]);
            min[i] = mini;
        }

        for(int i = 0; i < len; i++)
        {
            maxi = Math.max(maxi, nums[i]);
            if(maxi - min[i] <= k) 
                return i;
        }

        return -1;
    }
}