class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        int ct = 0;

        for(int num : nums)
        {
            freq[num]++;
            max = Math.max(freq[num], max);
        }

        for(int num : freq)
        {
            if(num == max)
                ct += num;
        }

        return ct;
    }
}