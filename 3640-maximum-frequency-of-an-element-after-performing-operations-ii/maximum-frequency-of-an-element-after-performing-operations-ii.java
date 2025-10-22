

// import java.util.*;

// class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
//         int maxValue = Arrays.stream(nums).max().getAsInt() + k;

//         int[] prefixFreq = new int[maxValue + 1];
//         for (int num : nums) {
//             prefixFreq[num]++;
//         }

//         // Build cumulative frequency (prefix sum)
//         for (int i = 1; i <= maxValue; i++) {
//             prefixFreq[i] += prefixFreq[i - 1];
//         }

//         int maxFrequency = 0;
//         for (int targetValue = 0; targetValue <= maxValue; targetValue++) {
//             if (prefixFreq[targetValue] == 0)
//                 continue;

//             int lowerBound = Math.max(0, targetValue - k);
//             int upperBound = Math.min(maxValue, targetValue + k);

//             int totalInRange = prefixFreq[upperBound] - (lowerBound > 0 ? prefixFreq[lowerBound - 1] : 0);
//             int currentValueCount = prefixFreq[targetValue] - (targetValue > 0 ? prefixFreq[targetValue - 1] : 0);

//             int convertibleCount = totalInRange - currentValueCount;
//             int possibleFrequency = currentValueCount + Math.min(convertibleCount, numOperations);

//             maxFrequency = Math.max(maxFrequency, possibleFrequency);
//         }

//         return maxFrequency;
//     }
// }


class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxPossibleValue = Arrays.stream(nums).max().getAsInt() + k;
        TreeMap<Integer, Integer> diffMap = new TreeMap<>();
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();

        // Count frequency and prepare difference map
        for (int num : nums) {
            numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);

            int lowerBound = Math.max(num - k, 0);
            int upperBound = Math.min(num + k, maxPossibleValue);

            diffMap.put(lowerBound, diffMap.getOrDefault(lowerBound, 0) + 1);
            diffMap.put(upperBound + 1, diffMap.getOrDefault(upperBound + 1, 0) - 1);

            // Ensure key exists for later iteration
            diffMap.putIfAbsent(num, diffMap.getOrDefault(num, 0));
        }

        int maxFrequencyResult = 1;
        int cumulativeSum = 0;

        // Iterate through difference map to calculate max frequency
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            int targetNumber = entry.getKey();
            int diffValue = entry.getValue();

            cumulativeSum += diffValue;
            int currentFreq = numberFrequency.getOrDefault(targetNumber, 0);
            int conversionsNeeded = cumulativeSum - currentFreq;

            int achievableFreq = Math.min(conversionsNeeded, numOperations);
            maxFrequencyResult = Math.max(maxFrequencyResult, currentFreq + achievableFreq);
        }

        return maxFrequencyResult;
    }
}
