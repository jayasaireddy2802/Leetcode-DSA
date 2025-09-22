// class Solution {
//     public int maxFrequencyElements(int[] nums) {
//         int[] freq = new int[101];
//         int max = 0;
//         int ct = 0;

//         for(int num : nums)
//         {
//             freq[num]++;
//             max = Math.max(freq[num], max);
//         }

//         for(int num : freq)
//         {
//             if(num == max)
//                 ct += num;
//         }

//         return ct;
//     }
// }

// class Solution {
//     public int maxFrequencyElements(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();

//         int max = 0;
//         int ct = 0;

//         for(int num : nums)
//         {
//             int val = map.getOrDefault(num, 0) + 1;
//             map.put(num, val);
//             max = Math.max(val, max);
//         }

//         for(int num : map.values())
//         {
//             if(num == max)
//                 ct += num;
//         }

//         return ct;
//     }
// }


class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        int ct = 0;

        for(int num : nums)
        {
            freq[num]++;
            max = Math.max(freq[num], max);
        }

        for(int num : nums)
        {
            if(freq[num] == max)
            {
                ct += freq[num];
                freq[num] = 0;
            }
        }

        return ct;
    }
}

