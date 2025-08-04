// class Solution {
//     public int totalFruit(int[] fruits) {
        
//         int len = fruits.length;
//         int maxi = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = 0; j < len; j++)
//             {
//                 Set<Integer> set = new HashSet<>();
//                 for(int k = i; k <= j; k++)
//                     set.add(fruits[k]);
//                 if(set.size() <= 2)
//                     maxi = Math.max(maxi, (j - i + 1));
//             }
//         }

//         return maxi;
//     }
// }

// class Solution {
//     public int totalFruit(int[] fruits) {
        
//         int len = fruits.length;
//         int maxi = 0;

//         for(int i = 0; i < len; i++)
//         {
//             Set<Integer> set = new HashSet<>();
//             for(int j = i; j < len; j++)
//             {
//                 set.add(fruits[j]);
//                 if(set.size() <= 2)
//                     maxi = Math.max(maxi, (j - i + 1));
//                 else
//                     break;
//             }
//         }

//         return maxi;
//     }
// }

class Solution {
    public int totalFruit(int[] fruits) {
        
        int len = fruits.length;
        int maxi = 0, i = 0, j = 0;
        int currlen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < len)
        {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            currlen++;
            if(map.size() <= 2)
            {
                maxi = Math.max(maxi, currlen);
            }
            while(map.size() > 2 && i < len)
            {
                int val = map.get(fruits[i]);
                if(val == 1)
                    map.remove(fruits[i]);
                else
                    map.put(fruits[i], val - 1);
                currlen--;
                i++;
            }

            maxi = Math.max(maxi, currlen);
            j++;
        }
        
        return maxi;
    }
}