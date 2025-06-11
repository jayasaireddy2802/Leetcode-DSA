// class Solution {

//     public int findMax(int i, int j, String s)
//     {
//         int[] freq = new int[5];
//         for(int k = i; k <= j; k++)
//         {
//             freq[s.charAt(k) - '0']++;
//         }
//         int oddMaxFreq = Integer.MIN_VALUE;
//         int evenMinFreq = Integer.MAX_VALUE;

//         for(int num : freq)
//         {
//             if(num == 0)
//                 continue;
//             if(num % 2 == 1)
//                 oddMaxFreq = Math.max(oddMaxFreq, num);
//             else
//                 evenMinFreq = Math.min(evenMinFreq, num);
//         }
        
//         if(oddMaxFreq == Integer.MIN_VALUE)
//             return Integer.MIN_VALUE;
//         if(evenMinFreq == Integer.MAX_VALUE)
//             return Integer.MAX_VALUE;

//         return oddMaxFreq - evenMinFreq;

//     }

//     public int maxDifference(String s, int k) {
//         int len = s.length();
//         int ans = Integer.MIN_VALUE;

//         for(int i = 0; i <= len - k; i++)
//         {
//             for(int j = i + k - 1; j < len; j++)
//             {
//                 int res = findMax(i, j, s);
//                 if(res == Integer.MAX_VALUE || res == Integer.MIN_VALUE)
//                     continue;
//                 ans = Math.max(ans, res);
//             }
//         }

//         return ans;
//     }
// }

// class Solution {

//     public int maxDifference(String s, int k) {
//         int len = s.length();
//         int ans = Integer.MIN_VALUE;
//         int[][] dp = new int[5][len + 1];

//         for(int i = 0; i < 5; i++)
//         {
//             for(int j = 0; j < len; j++)
//             {
//                 int digit = s.charAt(j) - '0';
//                 dp[i][j + 1] = dp[i][j] + ((digit == i) ? 1 : 0);
//             }
//         }

//         for(int a = 0; a < 5; a++)
//         {
//             for(int b = 0; b < 5; b++)
//             {
//                 if(a == b)
//                     continue;

//                 for(int i = 0; i <= len - k; i++)
//                 {
//                     for(int j = i + k - 1; j < len; j++)
//                     {
//                         int freq_a = dp[a][j + 1] - dp[a][i];
//                         int freq_b = dp[b][j + 1] - dp[b][i];

//                         if(freq_a % 2 == 1 && freq_b >= 2 && freq_b % 2 == 0)
//                             ans = Math.max(ans, freq_a - freq_b);
//                     }
//                 }
//             }
//         }

//         return ans;
//     }
// }

public class Solution {

    private int getState(int count_a, int count_b) {
        int parity_a = count_a % 2;
        int parity_b = count_b % 2;

        if (parity_a == 0 && parity_b == 0) return 0; // even even
        if (parity_a == 0 && parity_b == 1) return 1; // even odd
        if (parity_a == 1 && parity_b == 0) return 2; // odd even
        return 3; // odd odd
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        int result = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int[] stateMinPrev_a_b = new int[4];
                Arrays.fill(stateMinPrev_a_b, Integer.MAX_VALUE);

                int count_a = 0;
                int count_b = 0;

                int prev_a = 0;
                int prev_b = 0;

                int l = -1;
                int r = 0;

                while (r < n) {
                    count_a += (s.charAt(r) == a) ? 1 : 0;
                    count_b += (s.charAt(r) == b) ? 1 : 0;

                    while (r - l >= k && count_b - prev_b >= 2 && count_a - prev_a >= 1) {
                        int leftState = getState(prev_a, prev_b);
                        stateMinPrev_a_b[leftState] = Math.min(stateMinPrev_a_b[leftState], prev_a - prev_b);

                        l++;
                        if (s.charAt(l) == a) prev_a++;
                        if (s.charAt(l) == b) prev_b++;
                    }

                    int rightState = getState(count_a, count_b);
                    int bestLeftState = rightState ^ 2;
                    int bestMinDiffValueLeft = stateMinPrev_a_b[bestLeftState];

                    if (bestMinDiffValueLeft != Integer.MAX_VALUE) {
                        result = Math.max(result, (count_a - count_b) - bestMinDiffValueLeft);
                    }

                    r++;
                }
            }
        }

        return result;
    }
}