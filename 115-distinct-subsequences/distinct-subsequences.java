// class Solution {

//     public int solve(int idx, String s, String t, StringBuilder sb)
//     {
//         int len = s.length();
//         if(len == idx) 
//         {
//             return (sb.toString().equals(t)) ? 1 : 0;
//         }

//         int take = 0;
//         sb.append(s.charAt(idx));
//         take = solve(idx + 1, s, t, sb);
//         sb.deleteCharAt(sb.length() - 1);

//         int skip = solve(idx + 1, s, t, sb);
//         return take + skip;

//     }

//     public int numDistinct(String s, String t) {
//         return solve(0, s, t, new StringBuilder());
//     }
// }

// class Solution {

//     public int solve(int idx, String s, String t, StringBuilder sb, Map<String, Integer> map)
//     {
//         int len = s.length();
//         if(len == idx) 
//         {
//             return (sb.toString().equals(t)) ? 1 : 0;
//         }

//         String str = idx + sb.toString();
//         if(map.getOrDefault(str, null) != null)
//             return map.get(str);

//         int take = 0;
//         sb.append(s.charAt(idx));
//         take = solve(idx + 1, s, t, sb, map);
//         sb.deleteCharAt(sb.length() - 1);

//         int skip = solve(idx + 1, s, t, sb, map);
//         map.put(str, take + skip);
//         return map.get(str);
//     }

//     public int numDistinct(String s, String t) {
//         Map<String, Integer> map = new HashMap<>();
//         return solve(0, s, t, new StringBuilder(), map);
//     }
// }



class Solution {

    public int solve(int i, int j, String s, String t, int[][] dp) {

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0;

        if (s.charAt(i) == t.charAt(j)) {
            take = solve(i + 1, j + 1, s, t, dp);
        }

        int skip = solve(i + 1, j, s, t, dp);

        return dp[i][j] = take + skip;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s, t, dp);
    }
}