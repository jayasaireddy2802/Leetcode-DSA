class Solution {

    private boolean canAchieve(long targetPower, long[] differenceArr, int radius, long extraStations, int length) {
        long[] tempDifference = Arrays.copyOf(differenceArr, length);
        long runningSum = 0;

        for (int idx = 0; idx < length; idx++) {
            runningSum += tempDifference[idx];

            if (runningSum < targetPower) {
                long required = targetPower - runningSum;
                if (required > extraStations) {
                    return false;
                }

                extraStations -= required;
                runningSum += required;

                // Apply difference effect on future index after coverage window
                int endIndex = (int)(idx + 2L * radius + 1);
                if (endIndex < length) {
                    tempDifference[endIndex] -= required;
                }
            }
        }
        return true;
    }

    public long maxPower(int[] stationPower, int radius, int extraStations) {
        int length = stationPower.length;
        long[] differenceArr = new long[length];

        // Build initial difference array from power coverage
        for (int i = 0; i < length; i++) {
            int left = Math.max(0, i - radius);
            int right = i + radius + 1;
            differenceArr[left] += stationPower[i];
            if (right < length) differenceArr[right] -= stationPower[i];
        }

        long low = Arrays.stream(stationPower).min().getAsInt();
        long high = Arrays.stream(stationPower).asLongStream().sum() + extraStations;
        long answer = 0;

        // Binary search for maximum possible minimum power
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canAchieve(mid, differenceArr, radius, extraStations, length)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}
