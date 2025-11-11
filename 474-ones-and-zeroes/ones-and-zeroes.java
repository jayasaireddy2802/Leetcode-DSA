class Solution {
    public int findMaxForm(String[] strs, int maxZeros, int maxOnes) {
        int[][] dp = new int[maxZeros + 1][maxOnes + 1];

        for (String s : strs) {
            int countZero = 0, countOne = 0;

            for (char c : s.toCharArray()) {
                if (c == '0')
                    countZero++;
                else
                    countOne++;
            }

            // Traverse backward to avoid overwriting states
            for (int z = maxZeros; z >= countZero; z--) {
                for (int o = maxOnes; o >= countOne; o--) {
                    dp[z][o] = Math.max(dp[z][o], dp[z - countZero][o - countOne] + 1);
                }
            }
        }

        return dp[maxZeros][maxOnes];
    }
}
