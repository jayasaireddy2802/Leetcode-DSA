// class Solution {
//     public int maximumCount(int[] nums) {
//         int negativeCount = 0;
//         int positiveCount = 0;

//         for(int num : nums)
//         {
//             if(num > 0)
//                 positiveCount++;
//             else if(num < 0)
//                 negativeCount++;
//         }

//         return Math.max(positiveCount, negativeCount);
//     }
// }

class Solution {
    public int maximumCount(int[] nums) {
        
        int len = nums.length;
        int i = 0, j = len - 1, mid = 0;
        int ans1 = -1, ans2 = -1;

        while(i <= j)
        {
            mid = (i + j)/2;

            if(nums[mid] < 0)
            {
                ans1 = mid;
                i = mid + 1;
            }
            else
                j = mid - 1;
        }

        i = 0;
        j = len - 1;
        while(i <= j)
        {
            mid = (i + j)/2;

            if(nums[mid] > 0)
            {
                ans2 = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }
    
        if(ans2 == -1 && ans1 == -1)
        {
            return 0;
        }
        else if(ans2 == -1)
            return ans1 +1;
        else if(ans1 == -1)
            return len - ans2;
        return Math.max(ans1 + 1, len - ans2);
    }
}
