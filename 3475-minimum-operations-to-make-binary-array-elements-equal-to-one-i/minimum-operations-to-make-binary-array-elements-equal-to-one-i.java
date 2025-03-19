// class Solution {

//     public boolean checkArray(int[] nums)
//     {
//         for(int num : nums){
//             if(num == 0)
//                 return false;
//         }

//         return true;
//     }

//     public void flipTheBits(int[] nums, int i)
//     {
//         nums[i] = nums[i] ^ 1;
//         nums[i+1] = nums[i+1] ^ 1;
//         nums[i+2] = nums[i+2] ^ 1;
//     }

//     public int minOperations(int[] nums) {
//         int len = nums.length;
//         int ct = 0;
//         for(int i = 0; i < len-2; i++)
//         {
//             if(nums[i] == 0)
//             {
//                 flipTheBits(nums, i);
//                 ct++;
//             }
//             if(checkArray(nums))
//                 return ct;
//         }

//         return -1;

//     }
// }



class Solution {

    public int flipTheBits(int[] nums, int i)
    {
        int ct = 0;

        nums[i] = nums[i] ^ 1;
        if(nums[i] == 0)
            ct++;
        else
            ct--;

        nums[i+1] = nums[i+1] ^ 1;
        if(nums[i+1] == 0)
            ct++;
        else
            ct--;

        nums[i+2] = nums[i+2] ^ 1;
        if(nums[i+2] == 0)
            ct++;
        else
            ct--;
        
        return ct;
    }

    public int minOperations(int[] nums) {
        int len = nums.length;
        int ct = 0;
        int countOnes = 0;

        for(int num : nums)
        {
            if(num == 1)
                countOnes++;
        }

        if(countOnes == len)
            return 0;

        for(int i = 0; i < len-2; i++)
        {
            if(nums[i] == 0)
            {
                int count = flipTheBits(nums, i);
                countOnes = countOnes - count;
                ct++;
            }
            if(countOnes == len)
                return ct;
        }

        return -1;

    }
}
