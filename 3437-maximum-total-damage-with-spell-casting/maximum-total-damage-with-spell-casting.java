// class Solution {

//     public long solve(int idx, List<Integer> list, Map<Integer, Integer> map, int prev)
//     {
//         if(idx >= list.size())
//             return 0;

//         long notTake = solve(idx + 1, list, map, prev);
//         long take = 0;
//         int val = list.get(idx);
//         if(val >= prev + 3)
//             take = (long)val * map.get(val) + solve(idx + 1, list, map, val);

//         return Math.max(notTake, take);
//     }

//     public long maximumTotalDamage(int[] power) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int num : power)
//         {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>(map.keySet());
//         // Collections.sort(list);

//         return solve(0, list, map, -4);
//     }   
// }

// class Solution {

//     Map<String, Long> memo;

//     public long solve(int idx, List<Integer> list, Map<Integer, Integer> map, int prev, Map<String, Long> memo)
//     {
//         if(idx >= list.size())
//             return 0;

//         String str = idx + "#" + prev;
//         if(memo.containsKey(str))
//             return memo.get(str);

//         long notTake = solve(idx + 1, list, map, prev, memo);
//         long take = 0;
//         int val = list.get(idx);
//         if(val >= prev + 3)
//             take = (long)val * map.get(val) + solve(idx + 1, list, map, val, memo);

//         long ans = Math.max(notTake, take);
//         memo.put(str, ans);
//         return ans;
//     }

//     public long maximumTotalDamage(int[] power) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int num : power)
//         {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>(map.keySet());
//         Collections.sort(list);

//         memo = new HashMap<>();

//         return solve(0, list, map, -3, memo);
//     }   
// }




// class Solution {

//     Map<String, Long> memo;

//     public int getIndex(List<Integer> list, int num)
//     {
//         int ans = -1;
//         int i = 0, j = list.size() - 1;

//         while(i <= j)
//         {
//             int mid = (i + j)/2;
//             if(list.get(mid) >= num)
//             {
//                 ans = mid;
//                 j = mid - 1;
//             }
//             else
//                 i = mid + 1;
//         }

//         return ans;
//     }

//     public long solve(int idx, List<Integer> list, Map<Integer, Integer> map, int prev, Map<String, Long> memo)
//     {
//         if(idx >= list.size())
//             return 0;

//         String str = idx + "#" + prev;
//         if(memo.containsKey(str))
//             return memo.get(str);

//         long notTake = solve(idx + 1, list, map, prev, memo);
//         long take = 0;
//         int val = list.get(idx);
//         int newIdx = getIndex(list, val + 3);
//         if(val >= prev + 3)
//             take = (long)val * map.get(val) + solve(idx + 1, list, map, val, memo);

//         long ans = Math.max(notTake, take);
//         memo.put(str, ans);
//         return ans;
//     }

//     public long maximumTotalDamage(int[] power) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int num : power)
//         {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>(map.keySet());
//         Collections.sort(list);

//         memo = new HashMap<>();

//         return solve(0, list, map, -3, memo);
//     }   
// }



import java.util.*;

class Solution {

    Map<Integer, Long> memo = new HashMap<>();

    public int getIndex(List<Integer> list, int num) {
        int i = 0, j = list.size() - 1, ans = list.size();
        while (i <= j) {
            int mid = (i + j) / 2;
            if (list.get(mid) >= num) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public long solve(int idx, List<Integer> list, Map<Integer, Integer> map, long[] dp) {
        if (idx >= list.size()) return 0;
        if (dp[idx] != -1) return dp[idx];

        int val = list.get(idx);
        int nextIdx = getIndex(list, val + 3);

        long take = (long) val * map.get(val) + solve(nextIdx, list, map, dp);
        long skip = solve(idx + 1, list, map, dp);

        return dp[idx] = Math.max(take, skip);
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : power)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        long[] dp = new long[list.size()];
        Arrays.fill(dp, -1);

        return solve(0, list, map, dp);
    }
}
