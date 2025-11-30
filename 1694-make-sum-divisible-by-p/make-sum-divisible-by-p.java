// class Solution {

//     public int subArrayLength(long target, int[] nums, int p)
//     {
//         int len = nums.length;
//         int minLength = len + 1;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 long sum = 0;
//                 for(int k = i; k <= j; k++)
//                 {
//                     sum += nums[k];
//                 }
//                 if(sum % p == target)
//                     minLength = Math.min(minLength, j - i + 1);
//             }
//         }

//         if(minLength == len + 1 || minLength == len)
//             return -1;
//         else
//             return minLength;
//     }


//     public int minSubarray(int[] nums, int p) {
//         long sum = 0;
//         for(int num : nums)
//             sum += num;
        
//         long target =(sum % p);
//         if(target == 0)
//             return 0;

//         int ans = subArrayLength(target, nums, p);
//         return ans;
//     }
// } 



// class Solution {

//     public int subArrayLength(long target, int[] nums, int p)
//     {
//         int len = nums.length;
//         int minLength = len + 1;

//         long[] prefix = new long[len + 1];

//         for(int i = 1; i <= len; i++)
//             prefix[i] = prefix[i-1] + nums[i - 1];

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 long sum = prefix[j + 1] - prefix[i];
//                 if(sum % p == target)
//                     minLength = Math.min(minLength, j - i + 1);
//             }
//         }

//         if(minLength == len + 1 || minLength == len)
//             return -1;
//         else
//             return minLength;
//     }


//     public int minSubarray(int[] nums, int p) {
//         long sum = 0;
//         for(int num : nums)
//             sum += num;
        
//         long target =(sum % p);
//         if(target == 0)
//             return 0;

//         int ans = subArrayLength(target, nums, p);
//         return ans;
//     }
// } 




class Solution {

    public int subArrayLength(long target, int[] nums, int p)
    {
        int len = nums.length;
        int minLength = len + 1;

        long prefix = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        for(int i = 0; i < len; i++)
        {
            prefix = (prefix + nums[i]) % p;
            
            long need = (prefix - target + p) % p;

            if(map.containsKey(need))
                minLength = Math.min(minLength, i - map.get(need));
            map.put(prefix, i);
        }

        if(minLength == len + 1 || minLength == len)
            return -1;
        else
            return minLength;
    }


    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num : nums)
            sum += num;
        
        long target =(sum % p);
        if(target == 0)
            return 0;

        int ans = subArrayLength(target, nums, p);
        return ans;
    }
} 