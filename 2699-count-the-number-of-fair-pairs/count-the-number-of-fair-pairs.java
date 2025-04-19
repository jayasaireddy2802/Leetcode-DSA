// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         long ans = 0;
//         int len = nums.length;
//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i + 1; j < len; j++)
//             {
//                 int sum = nums[i] + nums[j];
//                 if(sum >= lower && sum <= upper)
//                     ans++;
//             }
//         }
//         return ans;
//     }
// }

class Solution {

    private int lower(int[] nums, int target, int i, int j)
    {
        int mid = 0;
        while(i <= j)
        {
            mid = (i + j) / 2;
            if(nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return i;
    }

    private int upper(int[] nums, int target, int i, int j)
    {
        int mid = 0;
        while(i <= j)
        {
            mid = (i + j) / 2;
            if(nums[mid] <= target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return i;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int len = nums.length;
        
        Arrays.sort(nums);

        for(int i = 0; i < len; i++)
        {
            int x = lower(nums, lower - nums[i], i + 1, len - 1);
            int y = upper(nums, upper - nums[i], i + 1, len - 1);

            ans = ans + (y - x);
        }

        return ans;

    }
}