
// Memory limit exceeded
// brute force

// class Solution {
//     public int count(int[] color, int limit)
//     {
//         Set<Integer> set = new HashSet<>();

//         for(int i = 0; i < limit; i++)
//         {
//             if(color[i] != 0)
//             {
//                 set.add(color[i]);
//             }
//         }

//         return set.size();
//     }

//     public int[] queryResults(int limit, int[][] queries) {
//         int q = queries.length;
//         int[] color = new int[limit+1];
//         int[] ans = new int[q];
      

//         for(int i = 0; i < q; i++)
//         {
//             int x = queries[i][0];
//             int y = queries[i][1];

//             color[x] = y;
//             int ct = count(color, limit+1);

//             ans[i] = ct;
//         }

//         return ans;
//     }
// }

// time limit exceed


// class Solution {
//     public int count(Map<Integer, Integer> map)
//     {
//         Set<Integer> set = new HashSet<>();

//         map.forEach((key, value) -> set.add(value));

//         return set.size();
//     }
    
//     public int[] queryResults(int limit, int[][] queries) {
//         int q = queries.length;
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] ans = new int[q];
      

//         for(int i = 0; i < q; i++)
//         {
//             int x = queries[i][0];
//             int y = queries[i][1];

//             map.put(x, y);
//             int ct = count(map);

//             ans[i] = ct;
//         }

//         return ans;
//     }
// }


class Solution {
  
    
    public int[] queryResults(int limit, int[][] queries) {
        int q = queries.length;
        Map<Integer, Integer> color_count = new HashMap<>();
        Map<Integer, Integer> ball_color = new HashMap<>();
        int[] ans = new int[q];
        Set<Integer> set = new HashSet<>();
            int prev_color = -1;
      

        for(int i = 0; i < q; i++)
        {
            int x = queries[i][0];
            int y = queries[i][1];

            if(ball_color.containsKey(x))
            {
                prev_color = ball_color.get(x);
                if(color_count.containsKey(prev_color))
                {
                    if(color_count.get(prev_color) == 1)
                        color_count.remove(prev_color);
                    else
                        color_count.put(prev_color, color_count.get(prev_color) - 1);
                }


            }
            
            if(color_count.getOrDefault(y, -1) == -1)
                color_count.put(y, 1);
            else
                color_count.put(y, color_count.get(y) + 1);

            ball_color.put(x, y);


            ans[i] = color_count.size();
        }

        return ans;
    }
}