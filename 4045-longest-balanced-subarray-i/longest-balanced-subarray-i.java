// class Solution {
//     public int longestBalanced(int[] nums) {
//         int len = nums.length;
//         int maxLength = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 Set<Integer> oddSet = new HashSet<>();
//                 Set<Integer> evenSet = new HashSet<>();

//                 for(int k = i; k <= j; k++)
//                 {
//                     if(nums[k] % 2 == 0)
//                         evenSet.add(nums[k]);
//                     else
//                         oddSet.add(nums[k]);
//                 }

//                 if(oddSet.size() == evenSet.size())
//                     maxLength = Math.max(maxLength, j - i + 1);
//             }
//         }

//         return maxLength;
//     }
// }

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0)
                    evenSet.add(nums[j]);
                else
                    oddSet.add(nums[j]);

                if (evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
