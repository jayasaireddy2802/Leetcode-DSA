// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int len = nums.length;
//         int n = len / 2;

//         Map<Integer, Integer> map = new HashMap<>();

//         for(int num : nums)
//             map.put(num, map.getOrDefault(num, 0) + 1);
        
//         for(int key : map.keySet())
//         {
//             if(map.get(key) == n)
//                 return key;
//         }

//         return -1;        
//     }
// }


// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int len = nums.length;
//         int n = len / 2;

//         Set<Integer> set = new HashSet<>();

//         for(int num : nums)
//         {
//             if(set.contains(num))
//                 return num;
//             set.add(num);
//         }    

//         return -1;
//     }
// }


class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;

        for(int i = 1; i < len; i++)
        {
            if(nums[i] == nums[i-1] ||(i - 2 >= 0 && nums[i] == nums[i-2]))
                return nums[i];
        }

        return nums[0];        
    }
}