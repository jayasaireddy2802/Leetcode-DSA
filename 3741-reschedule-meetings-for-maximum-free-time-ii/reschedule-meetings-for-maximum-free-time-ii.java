class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int len = startTime.length;
        int[] freeTime = new int[len + 1];
        int[] leftMaxGap = new int[len + 1];
        int[] rightMaxGap = new int[len + 1];
        int ans = 0;

        // Step 1: Calculate gaps between events
        freeTime[0] = startTime[0];
        for (int i = 1; i < len; i++) {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }
        freeTime[len] = eventTime - endTime[len - 1];

        // Step 2: Prefix max of gaps
        int max = freeTime[0];
        for (int i = 1; i <= len; i++) {
            leftMaxGap[i] = max;
            max = Math.max(max, freeTime[i]);
        }

        // Step 3: Suffix max of gaps
        max = freeTime[len];
        for (int i = len - 1; i >= 0; i--) {
            rightMaxGap[i] = max;
            max = Math.max(max, freeTime[i]);
        }

        // Step 4: Try removing each event
        for (int i = 0; i < len; i++) {
            int val = endTime[i] - startTime[i];

            if (leftMaxGap[i] >= val || rightMaxGap[i + 1] >= val) {
                ans = Math.max(ans, val + freeTime[i] + freeTime[i + 1]);
            } else {
                ans = Math.max(ans, freeTime[i] + freeTime[i + 1]);
            }
        }

        return ans;
    }
}
