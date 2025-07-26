class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long ans = 0;
        long[] extra = new long[n + 1];

        // Build the conflict map: store lower value in list of higher value
        for (int[] pairs : conflictingPairs) {
            int a = Math.min(pairs[0], pairs[1]);
            int b = Math.max(pairs[0], pairs[1]);

            List<Integer> list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            map.put(b, list);
        }

        int maxi = 0;
        int secondMax = 0;

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                for (int val : map.get(i)) {
                    if (val >= maxi) {
                        secondMax = maxi;
                        maxi = val;
                    } else if (val > secondMax) {
                        secondMax = val;
                    }
                }
            }

            ans += (i - maxi); // Count valid subarrays ending at i
            extra[maxi] += (maxi - secondMax); // Possible gain if we remove the conflict at maxi
        }

        long max = 0;
        for (long val : extra) {
            max = Math.max(max, val);
        }

        return ans + max;
    }
}
