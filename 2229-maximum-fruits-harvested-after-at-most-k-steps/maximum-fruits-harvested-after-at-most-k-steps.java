class Solution {
    public int maxTotalFruits(int[][] fruitPositions, int start, int maxSteps) {
        int totalFruits = fruitPositions.length;
        int[] cumulativeFruits = new int[totalFruits];
        int[] fruitLocations = new int[totalFruits];

        // Create prefix sum array and extract fruit locations
        for (int i = 0; i < totalFruits; i++) {
            fruitLocations[i] = fruitPositions[i][0];
            cumulativeFruits[i] = fruitPositions[i][1] + (i > 0 ? cumulativeFruits[i - 1] : 0);
        }

        int maxCollected = 0;

        for (int stepsToOneSide = 0; stepsToOneSide <= maxSteps / 2; stepsToOneSide++) {
            // Case 1: Go left then right
            int remainingSteps = maxSteps - 2 * stepsToOneSide;
            int leftLimit = start - stepsToOneSide;
            int rightLimit = start + remainingSteps;

            int leftIndex = findLowerBound(fruitLocations, leftLimit);
            int rightIndex = findUpperBound(fruitLocations, rightLimit) - 1;

            if (leftIndex <= rightIndex) {
                int collected = cumulativeFruits[rightIndex] - (leftIndex > 0 ? cumulativeFruits[leftIndex - 1] : 0);
                maxCollected = Math.max(maxCollected, collected);
            }

            // Case 2: Go right then left
            remainingSteps = maxSteps - 2 * stepsToOneSide;
            leftLimit = start - remainingSteps;
            rightLimit = start + stepsToOneSide;

            leftIndex = findLowerBound(fruitLocations, leftLimit);
            rightIndex = findUpperBound(fruitLocations, rightLimit) - 1;

            if (leftIndex <= rightIndex) {
                int collected = cumulativeFruits[rightIndex] - (leftIndex > 0 ? cumulativeFruits[leftIndex - 1] : 0);
                maxCollected = Math.max(maxCollected, collected);
            }
        }

        return maxCollected;
    }

    // Binary search for first index where arr[i] >= target
    private int findLowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Binary search for first index where arr[i] > target
    private int findUpperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
