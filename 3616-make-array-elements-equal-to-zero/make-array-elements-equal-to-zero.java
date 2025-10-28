// class Solution {
//     public int isValid(int[] nums, int dir, int curr)
//     {
//         int len = nums.length;

//         while(curr >= 0 && curr < len)
//         {
//             if(nums[curr] == 0)
//                 curr += dir;
//             else
//             {
//                 nums[curr]--;
//                 if(dir == -1)
//                     dir = 1;
//                 else
//                     dir = -1;
//                 curr += dir;
//             }
//         }

//         for(int num : nums)
//         {
//             if(num != 0)
//                 return 0;
//         }

//         return 1;
//     }

//     public int countValidSelections(int[] nums) {
        
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             if(nums[i] == 0)
//             {
//                 ct = ct + isValid(nums.clone(), -1, i);
//                 ct += isValid(nums.clone(), 1, i);
//             }
//         }

//         return ct;
//     }
// }


class Solution {

    public int countValidSelections(int[] nums) {
        
        int len = nums.length;
        int ct = 0;
        int leftSum = 0;
        int rightSum = 0;

        for(int num : nums)
            rightSum += num;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 0)
            {
                if(leftSum == rightSum)
                    ct += 2;
                else if(rightSum - leftSum == 1)
                    ct++;
                else if(leftSum - rightSum == 1)
                    ct++;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }

        return ct;
    }
}