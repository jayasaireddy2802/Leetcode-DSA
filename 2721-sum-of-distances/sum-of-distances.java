// class Solution {
//     public long[] distance(int[] nums) {
//         int len = nums.length;
//         long[] res = new long[len];

//         for(int i = 0; i < len; i++)
//         {
//             long sum = 0;
//             for(int j = 0; j < len; j++)
//             {
//                 if(i != j && nums[i] == nums[j])
//                     sum += Math.abs(j - i);
//             }
//             res[i] = sum;
//         }
//         return res;
//     }
// }



class Solution {
    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] res = new long[len];
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();
        Map<Integer, Integer> totalFreq = new HashMap<>();
        Map<Integer, Long> totalSum = new HashMap<>();

        for(int i = 0; i < len; i++)
        {
            totalFreq.put(nums[i], totalFreq.getOrDefault(nums[i], 0) + 1);
            totalSum.put(nums[i], totalSum.getOrDefault(nums[i], 0l) + i);
        }

        for(int i = 0; i < len; i++)
        {
            long val1 = (long)freq.getOrDefault(nums[i], 0) * i - sum.getOrDefault(nums[i], 0l);
            long val2 = (totalSum.get(nums[i]) - sum.getOrDefault(nums[i], 0l)) - (long)(totalFreq.get(nums[i]) - freq.getOrDefault(nums[i], 0)) * i;
            sum.put(nums[i], sum.getOrDefault(nums[i], 0l) + i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            res[i] = val1 + val2;
        }

        return res;
         
    }
}