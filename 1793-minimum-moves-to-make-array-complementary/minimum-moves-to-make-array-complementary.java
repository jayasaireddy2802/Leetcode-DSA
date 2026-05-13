class Solution {

    public int minMoves(int[] arr, int limit) {
        int n = arr.length;
        int pairs = n / 2;

        Map<Integer, Integer> freq = new HashMap<>();
        int[] lower = new int[pairs];
        int[] higher = new int[pairs];

        // Build pairs and track sums
        for (int i = 0; i < pairs; i++) {
            int x = arr[i];
            int y = arr[n - 1 - i];

            int small = Math.min(x, y);
            int large = Math.max(x, y);

            freq.put(small + large, freq.getOrDefault(small + large, 0) + 1);

            lower[i] = small;
            higher[i] = large;
        }

        Arrays.sort(lower);
        Arrays.sort(higher);

        int answer = Integer.MAX_VALUE;

        // Try all possible target sums
        for (int target = 2; target <= 2 * limit; target++) {

            // Count pairs needing 2 operations from left side
            int leftChanges = pairs - firstGreaterOrEqual(lower, target);

            // Count pairs needing 2 operations from right side
            int rightChanges = firstGreaterOrEqual(higher, target - limit);

            int zeroChange = freq.getOrDefault(target, 0);

            int operations = pairs + leftChanges + rightChanges - zeroChange;

            answer = Math.min(answer, operations);
        }

        return answer;
    }

    // Custom binary search (lower bound)
    private int firstGreaterOrEqual(int[] nums, int key) {
        int start = 0, end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}