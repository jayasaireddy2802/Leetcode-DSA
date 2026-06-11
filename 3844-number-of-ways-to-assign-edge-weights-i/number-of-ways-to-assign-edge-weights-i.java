class Solution {

    private static final long MODULO = 1_000_000_007L;

    // Fast exponentiation (binary exponentiation)
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MODULO;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MODULO;
            }
            base = (base * base) % MODULO;
            exp >>= 1;
        }
        return result;
    }

    // DFS to compute maximum depth from a given node
    private int findHeight(Map<Integer, List<Integer>> graph, int current, int parent) {
        int maxHeight = 0;

        List<Integer> neighbors = graph.get(current);
        if (neighbors == null) return 0;

        for (int next : neighbors) {
            if (next == parent) continue;

            int childHeight = findHeight(graph, next, current);
            maxHeight = Math.max(maxHeight, childHeight + 1);
        }

        return maxHeight;
    }

    public int assignEdgeWeights(int[][] edges) {

        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        // Assuming root is node 1
        int depth = findHeight(graph, 1, -1);

        // Compute 2^(depth-1) % MOD
        return (int) modPow(2, depth - 1);
    }
}