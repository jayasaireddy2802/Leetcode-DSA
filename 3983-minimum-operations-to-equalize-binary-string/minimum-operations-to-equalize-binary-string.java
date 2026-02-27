class Solution {

    public int minOperations(String s, int k) {
        int len = s.length();

        // count initial zeros
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') zeroCount++;
        }

        // distance array
        int[] steps = new int[len + 1];
        Arrays.fill(steps, -1);

        // nodes grouped by parity
        List<TreeSet<Integer>> paritySets = new ArrayList<>();
        paritySets.add(new TreeSet<>());
        paritySets.add(new TreeSet<>());

        for (int i = 0; i <= len; i++) {
            paritySets.get(i & 1).add(i);
        }

        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(zeroCount);
        steps[zeroCount] = 0;
        paritySets.get(zeroCount & 1).remove(zeroCount);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int minFlip = Math.max(0, k - (len - cur));
            int maxFlip = Math.min(cur, k);

            int left = cur + k - 2 * maxFlip;
            int right = cur + k - 2 * minFlip;

            TreeSet<Integer> candidates = paritySets.get(left & 1);

            Integer next = candidates.ceiling(left);
            while (next != null && next <= right) {
                steps[next] = steps[cur] + 1;
                queue.offer(next);
                candidates.remove(next);
                next = candidates.ceiling(left);
            }
        }

        return steps[0];
    }
}