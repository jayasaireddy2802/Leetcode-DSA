class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int length = nums.length;

        Arrays.sort(nums);

        int distinctCount = 0;
        int lastChosenValue = Integer.MIN_VALUE;

        for (int index = 0; index < length; index++) {
            int minPossibleValue = nums[index] - k;

            if (lastChosenValue < minPossibleValue) {
                // Choose nums[index] - k
                lastChosenValue = minPossibleValue;
                distinctCount++;
            } else if (lastChosenValue < nums[index] + k) {
                // Choose next available distinct value greater than lastChosenValue
                lastChosenValue = lastChosenValue + 1;
                distinctCount++;
            }
        }

        return distinctCount;

    }
}