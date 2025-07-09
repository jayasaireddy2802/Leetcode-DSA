class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int len = startTime.length;
        int[] freeTime = new int[len + 1];
        
        freeTime[0] = startTime[0];
        freeTime[len] = eventTime - endTime[len -1];

        for(int i = 1; i < len ; i++)
        {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }

        int i = 0;
        int j = 0;
        int ct = 0;
        int sum = 0;
        int ans = 0;

        while(j <= len)
        {
            while(j <= len && ct < k+1)
            {
                sum += freeTime[j];
                j++;
                ct++;
            }

            ans = Math.max(ans, sum);
            sum -= freeTime[i];

            i++;
            ct--;
        }

        return ans;
    }
}