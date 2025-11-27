// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 int sum = 0;
//                 for(int m = i; m <= j; m++)
//                 {
//                     sum = sum + nums[m];
//                 }
//                 if(sum % k == 0)
//                     ct++;
//             }
//         }

//         return ct;
//     }
// }


// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int len = nums.length;
//         int ct = 0;


//         long[] prefix = new long[len + 1];
//         for(int i = 1; i <= len; i++)
//         {
//             prefix[i] = prefix[i-1] + nums[i - 1];
//         }
        
//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 long sum = prefix[j + 1] - prefix[i];
//                 if(sum % k == 0)
//                     ct++;
//             }
//         }

//         return ct;
//     }
// }

// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int len = nums.length;
//         int sum = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         int ans = 0;

//         map.put(sum, 1);

//         for(int i = 0; i < len; i++)
//         {
//             sum += nums[i];
//             int rem = (sum % k + k) % k;
//             if(map.containsKey(rem))
//                 ans += map.get(rem);;
//             map.put(rem, map.getOrDefault(rem, 0) + 1);
//         }

//         return ans;


//     }
// }




class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        map.put(sum, 1);

        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
            int rem = (sum % k + k) % k;
            int val = map.getOrDefault(rem, 0);
            ans += val;
            map.put(rem, val + 1);
        }

        return ans;


    }
}

