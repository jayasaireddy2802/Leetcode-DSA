class Solution {
    public int minRemoval(int[] numbers, int limit) {
        int length = numbers.length;
        Arrays.sort(numbers);

        int left = 0;
        int longestValidWindow = 1;

        for (int right = 0; right < length; right++) {
            long currentMax = numbers[right];
            long currentMin = numbers[left];

            while (left < right && currentMax > (long) limit * currentMin) {
                left++;
                currentMin = numbers[left];
            }

            longestValidWindow = Math.max(longestValidWindow, right - left + 1);
        }

        return length - longestValidWindow;
    }
}
