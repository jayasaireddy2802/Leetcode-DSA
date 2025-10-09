class Solution {

    public boolean isPossible(long start, int potion, int[] skill, int[] mana, long[] prevTime) {
        int n = skill.length;
        long time = start;

        for (int i = 0; i < n; i++) {
            if (time < prevTime[i]) 
                return false;
            time += (long) skill[i] * mana[potion];
        }

        return true;
    }

    public long binarySearch(int potion, int[] skill, int[] mana, long[] prevTime) {
        int n = skill.length;
        long low = prevTime[0] - 1;
        long high = prevTime[n - 1];

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (isPossible(mid, potion, skill, mana, prevTime))
                high = mid;
            else
                low = mid;
        }

        return high;
    }

    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] prevPotionTime = new long[n];
        long prev = 0;

        // First potion directly computed
        for (int i = 0; i < n; i++) {
            prev += (long) skill[i] * mana[0];
            prevPotionTime[i] = prev;
        }

        // Process remaining potions
        for (int i = 1; i < m; i++) {
            long currStartTime = binarySearch(i, skill, mana, prevPotionTime);

            for (int j = 0; j < n; j++) {
                // currStartTime = Math.max(currStartTime, prevPotionTime[j]);
                currStartTime += (long) skill[j] * mana[i];
                prevPotionTime[j] = currStartTime;
            }
        }

        return prevPotionTime[n - 1];
    }
}
