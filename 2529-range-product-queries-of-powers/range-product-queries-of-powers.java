class Solution {
    private static final int MODULO = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        List<Long> bitPowers = new ArrayList<>();
        
        // Extract powers of two from binary representation of n
        for (int bit = 0; bit < 32; bit++) {
            if (((n >> bit) & 1) == 1) {
                bitPowers.add(1L << bit);
            }
        }

        int[] answers = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];
            
            long product = 1;
            for (int idx = left; idx <= right; idx++) {
                product = (product * bitPowers.get(idx)) % MODULO;
            }
            answers[q] = (int) product;
        }

        return answers;
    }
}
