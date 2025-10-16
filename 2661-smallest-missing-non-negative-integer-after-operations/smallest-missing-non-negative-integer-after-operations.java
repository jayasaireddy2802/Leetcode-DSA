// class Solution {
//     public int findSmallestInteger(int[] nums, int value) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int num : nums)
//         {
//             int mod = (num % value + value) % value;
//             map.put(mod, map.getOrDefault(mod, 0) + 1);
//         }
            
//         int i = 0;
//         while(true)
//         {
//             int val = i % value;
//             if(map.getOrDefault(val, 0) == 0)
//                 return i;
//             map.put(val, map.get(val) - 1);
//             i++;
//         }

        
//     }

// }


class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] map = new int[value];

        for(int num : nums)
        {
            int mod = (num % value + value) % value;
            map[mod]++;
        }
            
        int i = 0;
        while(true)
        {
            int val = i % value;
            if(map[val] == 0)
                return i;
            map[val]--;
            i++;
        }

        
    }

}