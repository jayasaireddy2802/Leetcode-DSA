

// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         int len = rains.length;
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] ans = new int[len];
//         List<Integer> list = new ArrayList<>();

//         for(int i = 0; i < len; i++)
//         {
//             int lake = rains[i];
//             if(lake == 0)
//             {
//                 list.add(i);
//                 ans[i] = 1;
//             }            
//             else
//             {
//                 if(map.containsKey(lake))
//                 {
//                     int idx = -1;
//                     if(!list.isEmpty())
//                     {
//                         int val = map.get(lake);
//                         for(int l : list)
//                         {
//                             if(l > val)
//                             {
//                                 idx = l;
//                                 break;
//                             }
//                         }
//                         list.remove(Integer.valueOf(idx));

//                     }
//                     else
//                         return new int[0];
//                     if(idx == -1)
//                         return new int[0];
//                     ans[idx] = lake;
//                 }
//                 map.put(lake, i);
//                 ans[i] = -1;
//             }
            
//         }
        
//         return ans;
//     }
// }




class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[len];
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < len; i++)
        {
            int lake = rains[i];
            if(lake == 0)
            {
                set.add(i);
                ans[i] = 1;
            }            
            else
            {
                if(map.containsKey(lake))
                {
                    Integer idx = -1;
                    if (map.containsKey(lake)) {
                     idx = set.higher(map.get(lake)); 
                    if (idx == null) return new int[0];      
                    ans[idx] = lake; 
                    set.remove(idx);
                    }
                    if(idx == -1)
                        return new int[0];
                    ans[idx] = lake;
                }
                map.put(lake, i);
                ans[i] = -1;
            }
            
        }
        
        return ans;
    }
}