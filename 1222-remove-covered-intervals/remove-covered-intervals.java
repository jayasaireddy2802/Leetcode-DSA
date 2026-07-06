class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        boolean[] covered = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int a = intervals[i][0];
                int b = intervals[i][1];
                int c = intervals[j][0];
                int d = intervals[j][1];

                if (c <= a && b <= d) {
                    covered[i] = true;
                    break;
                }
            }
        }

        int count = 0;
        for (boolean c : covered) {
            if (!c) count++;
        }

        return count;
    }
}