class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int max1;
        int max2;
        int ct = 2;
        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        max1 = intervals[0][1] - 1;
        max2 = intervals[0][1];

        for(int i = 1; i < len; i++)
        {
            if(max2 < intervals[i][0])
            {
                ct += 2;
                max1 = intervals[i][1] - 1;
                max2 = intervals[i][1];
            }
            else if(max1 < intervals[i][0])
            {
                ct++;
                max1 = max2;
                max2 = intervals[i][1];
            }

        }

        return ct;
    }
}