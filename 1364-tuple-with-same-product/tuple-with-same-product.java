// class Solution {
//     public int tupleSameProduct(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         int ct = 0;

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = n-1; j > i; j--)
//             {
//                 int product = nums[i] * nums[j];

//                 for(int k = i + 1; k < j; k++)
//                 {
//                     for(int l = k + 1; l < j; l++)
//                     {
//                         if(nums[k] * nums[l] == product)
//                         {
//                             ct += 8;
//                         }
//                     }
//                 }
//             }
//         }

//         return ct;
//     }
// }

// class Solution {
//     public int tupleSameProduct(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         int ct = 0;

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = n-1; j > i; j--)
//             {
//                 int product = nums[i] * nums[j];
//                 Set<Integer> set = new HashSet<>();

//                 for(int k = i + 1; k < j; k++)
//                 {
//                     if(product % nums[k] == 0 && set.contains(product / nums[k]))
//                         ct += 8;
//                     set.add(nums[k]);
//                 }
//             }
//         }

//         return ct;
//     }
// }


class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
      
        int ct = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int product = nums[i] * nums[j];
                int val = map.getOrDefault(product, 0);
                if(val != 0)
                    ct += 8*val;
                map.put(product, val+1);
            }
        }

        return ct;
    }
}