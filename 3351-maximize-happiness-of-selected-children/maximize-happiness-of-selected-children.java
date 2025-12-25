class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int len = happiness.length;
        Arrays.sort(happiness);
        int ct = 0;
        int i = len - 1;

        while(k > 0)
        {
            if(happiness[i] - ct > 0)
                ans += happiness[i] - ct;
            k--;
            ct++;
            i--;
        }

        return ans;
    }
}