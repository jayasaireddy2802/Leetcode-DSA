// class Solution {
//     public int[] constructTransformedArray(int[] nums) {
//         int len = nums.length;
//         int[] result = new int[len];

//         for(int i = 0; i < len; i++)
//         {
//             int steps = Math.abs(nums[i]);
//             if(nums[i] == 0)
//                 result[i] = nums[i];
//             if(nums[i] > 0)
//             {
//                 int j = i;
//                 while(steps > 0)
//                 {
//                     j = (j + 1) % len;
//                     steps--;
//                 }
//                 result[i] = nums[j];
//             }

//             if(nums[i] < 0)
//             {
//                 int j = i;
//                 while(steps > 0)
//                 {
//                     j = (j - 1 + len) % len;
//                     steps--;
//                 }
//                 result[i] = nums[j];
//             }
//         }

//         return result;
//     }
// }

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for(int i = 0; i < len; i++)
        {
            int steps = Math.abs(nums[i]);
            if(nums[i] == 0)
                result[i] = nums[i];
            if(nums[i] > 0)
            {
                int j = i;
                
                    j = (j + steps) % len;
                result[i] = nums[j];
            }

            if(nums[i] < 0)
            {
                int j = i;
                while(steps > 0)
                {
                    j = (j - 1 + len) % len;
                    steps--;
                }
                result[i] = nums[j];
            }
        }

        return result;
    }
}