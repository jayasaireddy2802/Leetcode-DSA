class Solution {

    private boolean[] primeFlag;

    // Build sieve of Eratosthenes
    private void generatePrimes(int limit) {
        primeFlag = new boolean[limit + 1];
        Arrays.fill(primeFlag, true);

        if (limit >= 0) primeFlag[0] = false;
        if (limit >= 1) primeFlag[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (!primeFlag[p]) continue;

            for (int mul = p * p; mul <= limit; mul += p) {
                primeFlag[mul] = false;
            }
        }
    }

    public int minJumps(int[] arr) {
        int n = arr.length;

        // Map value -> indices
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        int maxValue = 0;

        for (int idx = 0; idx < n; idx++) {
            valueToIndices
                .computeIfAbsent(arr[idx], k -> new ArrayList<>())
                .add(idx);

            maxValue = Math.max(maxValue, arr[idx]);
        }

        // Prepare prime lookup
        generatePrimes(maxValue);

        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visitedIndex = new boolean[n];

        bfsQueue.offer(0);
        visitedIndex[0] = true;

        // To avoid reprocessing same value
        Set<Integer> processedValues = new HashSet<>();

        int jumps = 0;

        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();

            for (int k = 0; k < levelSize; k++) {
                int currentIndex = bfsQueue.poll();

                if (currentIndex == n - 1) {
                    return jumps;
                }

                // Move left
                int left = currentIndex - 1;
                if (left >= 0 && !visitedIndex[left]) {
                    visitedIndex[left] = true;
                    bfsQueue.offer(left);
                }

                // Move right
                int right = currentIndex + 1;
                if (right < n && !visitedIndex[right]) {
                    visitedIndex[right] = true;
                    bfsQueue.offer(right);
                }

                int value = arr[currentIndex];

                // Only process prime values once
                if (!primeFlag[value] || processedValues.contains(value)) {
                    continue;
                }

                // Jump to all indices having multiples of this value
                for (int nextVal = value; nextVal <= maxValue; nextVal += value) {

                    List<Integer> indices = valueToIndices.get(nextVal);
                    if (indices == null) continue;

                    for (int pos : indices) {
                        if (!visitedIndex[pos]) {
                            visitedIndex[pos] = true;
                            bfsQueue.offer(pos);
                        }
                    }
                }

                processedValues.add(value);
            }

            jumps++;
        }

        return -1;
    }
}