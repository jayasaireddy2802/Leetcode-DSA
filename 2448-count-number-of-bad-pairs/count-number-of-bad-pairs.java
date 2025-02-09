// Brute Force 


// class Solution {
//     public long countBadPairs(int[] nums) {
//         int n = nums.length;
//         long ct = 0;
//         for(int i = 0; i < n; i++)
//         {
//             for(int j = i; j < n; j++)
//             {
//                 if((i < j) && (j-i != nums[j] - nums[i]))
//                     ct++;
//             }
//         }
//         return ct;
//     }
// }

// Better
//  nums[i] - i != nums[j] - j

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long ct = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = nums[i] - i;
        }

        map.put(arr[0], 1);

        for(int j = 1; j < n; j++)
        {
            ct = ct + (j - map.getOrDefault(arr[j], 0));
            map.put(arr[j], 1 + map.getOrDefault(arr[j], 0));
        }

        return ct;
    }
}