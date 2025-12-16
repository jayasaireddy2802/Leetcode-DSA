class Solution {

    public int maxProfit(int n, int[] currentCost, int[] futureValue,
                         int[][] edges, int budget) {

        // Build tree
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] edge : edges) {
            tree[edge[0] - 1].add(edge[1] - 1);
        }

        // dp[node][isParentBought][budget]
        int[][][] dp = new int[n][2][budget + 1];

        dfs(0, currentCost, futureValue, tree, dp, budget);

        int maxProfit = 0;
        for (int b = 0; b <= budget; b++) {
            maxProfit = Math.max(maxProfit, dp[0][0][b]);
        }
        return maxProfit;
    }

    private void dfs(int node, int[] currentCost, int[] futureValue,
                     List<Integer>[] tree, int[][][] dp, int budget) {

        for (int b = 0; b <= budget; b++) {
            dp[node][0][b] = dp[node][1][b] = 0;
        }

        List<int[][]> childrenDP = new ArrayList<>();

        for (int child : tree[node]) {
            dfs(child, currentCost, futureValue, tree, dp, budget);
            childrenDP.add(new int[][]{dp[child][0], dp[child][1]});
        }

        for (int isParentBought = 0; isParentBought <= 1; isParentBought++) {

            int buyCost = (isParentBought == 1)
                    ? currentCost[node] / 2
                    : currentCost[node];

            int gain = futureValue[node] - buyCost;

            int[] resultDP = new int[budget + 1];

            /* Option 1: Do not buy this node */
            int[] skipNodeDP = new int[budget + 1];
            skipNodeDP[0] = 0;

            for (int[][] childDP : childrenDP) {
                int[] next = new int[budget + 1];
                for (int usedBudget = 0; usedBudget <= budget; usedBudget++) {
                    for (int childBudget = 0;
                         usedBudget + childBudget <= budget;
                         childBudget++) {

                        next[usedBudget + childBudget] =
                                Math.max(next[usedBudget + childBudget],
                                         skipNodeDP[usedBudget]
                                         + childDP[0][childBudget]);
                    }
                }
                skipNodeDP = next;
            }

            for (int b = 0; b <= budget; b++) {
                resultDP[b] = Math.max(resultDP[b], skipNodeDP[b]);
            }

            /* Option 2: Buy this node */
            if (buyCost <= budget) {
                int[] buyNodeDP = new int[budget + 1];
                buyNodeDP[0] = 0;

                for (int[][] childDP : childrenDP) {
                    int[] next = new int[budget + 1];
                    for (int usedBudget = 0; usedBudget <= budget; usedBudget++) {
                        for (int childBudget = 0;
                             usedBudget + childBudget <= budget;
                             childBudget++) {

                            next[usedBudget + childBudget] =
                                    Math.max(next[usedBudget + childBudget],
                                             buyNodeDP[usedBudget]
                                             + childDP[1][childBudget]);
                        }
                    }
                    buyNodeDP = next;
                }

                for (int b = buyCost; b <= budget; b++) {
                    resultDP[b] =
                            Math.max(resultDP[b],
                                     buyNodeDP[b - buyCost] + gain);
                }
            }

            dp[node][isParentBought] = resultDP;
        }
    }
}
