class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums)
        {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        while(min != 0)
        {
            int temp = max;
            max = min;
            min = temp % min;
        }

        return max;
    }
}