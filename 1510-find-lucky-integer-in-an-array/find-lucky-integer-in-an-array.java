// class Solution {
//     public int findLucky(int[] arr) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int ans = -1;

//         for(int num : arr)
//             map.put(num, map.getOrDefault(num, 0) + 1);
        
//         for(int key : map.keySet())
//         {
//             if(key == map.get(key))
//                 ans = key;
//         }

//         return ans;
//     }
// }


// class Solution {
//     public int findLucky(int[] arr) {
//         int[] freq = new int[501];
//         int ans = -1;

//         for(int num : arr)
//         {
//             freq[num]++;
//         }

//         for(int i = 1; i < 501; i++)
//         {
//             if(i == freq[i])
//                 ans = i;
//         }
        
//         return ans;
//     }
// }


class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        int ans = -1;

        for(int num : arr)
        {
            freq[num]++;
        }

        for(int i = 500; i > 0; i--)
        {
            if(i == freq[i])
                return i;
        }
        
        return ans;
    }
}