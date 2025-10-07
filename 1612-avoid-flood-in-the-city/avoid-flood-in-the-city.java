// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         int len = rains.length;
//         boolean[] isWater = new boolean[10000000];
//         int[] ans = new int[len];
//         List<Integer> list = new ArrayList<>();
//         int todry = 0;

//         for(int i = 0; i < len; i++)
//         {
//             int lake = rains[i];
//             if(lake == 0)
//             {
//                 list.add(i);

//             }            
//             else if(!isWater[lake])
//             {
//                 isWater[lake] = true;
//                 ans[i] = -1;
//                 todry++;
//             }
//             else 
//             {
//                 if(list.isEmpty())
//                     return new int[0];
//                 else
//                 {
//                     int idx = list.remove(0);
//                     if(idx < lake)
//                         return new int[0];
//                     ans[idx] = lake;
//                     ans[i] = -1;
                    
//                 }
//             }
//         }
        
//         for(int i = 0; i < len; i++)
//         {
//             if(ans[i] == 0) ans[i] = 1;
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[len];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < len; i++)
        {
            int lake = rains[i];
            if(lake == 0)
            {
                list.add(i);
                ans[i] = 1;
            }            
            else
            {
                if(map.containsKey(lake))
                {
                    int idx = -1;
                    if(!list.isEmpty())
                    {
                        int val = map.get(lake);
                        for(int l : list)
                        {
                            if(l > val)
                            {
                                idx = l;
                                break;
                            }
                        }
                        list.remove(Integer.valueOf(idx));

                    }
                    else
                        return new int[0];
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