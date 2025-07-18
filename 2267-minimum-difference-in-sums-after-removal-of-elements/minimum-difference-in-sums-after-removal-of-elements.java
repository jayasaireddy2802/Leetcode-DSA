class Solution {
    public long minimumDifference(int[] nums) {
        int totalLength = nums.length; // This is 3 * n
        int partitionSize = totalLength / 3;

        long[] minSumLeft = new long[totalLength];
        long[] maxSumRight = new long[totalLength];

        // Max heap to track smallest 'partitionSize' elements on the left
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        long currentLeftSum = 0;

        for (int i = 0; i < 2 * partitionSize; i++) {
            leftMaxHeap.offer(nums[i]);
            currentLeftSum += nums[i];

            if (leftMaxHeap.size() > partitionSize) {
                currentLeftSum -= leftMaxHeap.poll();
            }

            minSumLeft[i] = currentLeftSum;
        }

        // Min heap to track largest 'partitionSize' elements on the right
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        long currentRightSum = 0;

        for (int i = totalLength - 1; i >= partitionSize; i--) {
            rightMinHeap.offer(nums[i]);
            currentRightSum += nums[i];

            if (rightMinHeap.size() > partitionSize) {
                currentRightSum -= rightMinHeap.poll();
            }

            maxSumRight[i] = currentRightSum;
        }

        long minimumDifference = Long.MAX_VALUE;

        for (int i = partitionSize - 1; i <= 2 * partitionSize - 1; i++) {
            minimumDifference = Math.min(minimumDifference, minSumLeft[i] - maxSumRight[i + 1]);
        }

        return minimumDifference;
    }
}
