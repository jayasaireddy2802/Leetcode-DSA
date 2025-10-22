import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxValue = Arrays.stream(nums).max().getAsInt() + k;

        int[] prefixFreq = new int[maxValue + 1];
        for (int num : nums) {
            prefixFreq[num]++;
        }

        // Build cumulative frequency (prefix sum)
        for (int i = 1; i <= maxValue; i++) {
            prefixFreq[i] += prefixFreq[i - 1];
        }

        int maxFrequency = 0;
        for (int targetValue = 0; targetValue <= maxValue; targetValue++) {
            if (prefixFreq[targetValue] == 0)
                continue;

            int lowerBound = Math.max(0, targetValue - k);
            int upperBound = Math.min(maxValue, targetValue + k);

            int totalInRange = prefixFreq[upperBound] - (lowerBound > 0 ? prefixFreq[lowerBound - 1] : 0);
            int currentValueCount = prefixFreq[targetValue] - (targetValue > 0 ? prefixFreq[targetValue - 1] : 0);

            int convertibleCount = totalInRange - currentValueCount;
            int possibleFrequency = currentValueCount + Math.min(convertibleCount, numOperations);

            maxFrequency = Math.max(maxFrequency, possibleFrequency);
        }

        return maxFrequency;
    }
}
