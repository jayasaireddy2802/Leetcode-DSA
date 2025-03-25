class Solution {

    public List<int[]> merge(int[][] interval)
    {
        List<int[]> merged = new ArrayList<>();
        int[] prev = Arrays.copyOf(interval[0], 2);

        for(int i = 1; i < interval.length; i++)
        {
            int[] curr = interval[i];

            if(curr[0] < prev[1])
            {
                prev[0] = Math.min(curr[0], prev[0]);
                prev[1] = Math.max(curr[1], prev[1]);
            }
            else
            {
                merged.add(prev);
                prev = Arrays.copyOf(curr, 2);
            }
        }

        merged.add(prev);
        return merged;
    }


    public boolean checkValidCuts(int n, int[][] rectangles) {

        int len = rectangles.length;
        if(len == 0)
            return false;
        int[][] x_axis = new int[len][2];
        int[][] y_axis = new int[len][2];

        for(int i = 0; i < len; i++)
        {
            x_axis[i][0] = rectangles[i][0];
            x_axis[i][1] = rectangles[i][2];
            y_axis[i][0] = rectangles[i][1];
            y_axis[i][1] = rectangles[i][3];

        }

        Arrays.sort(x_axis, (a, b) -> a[0] - b[0]);
        Arrays.sort(y_axis, (a, b) -> a[0] - b[0]);

        List<int[]> xlist = merge(x_axis);
        List<int[]> ylist = merge(y_axis);

        return (xlist.size() >= 3 || ylist.size() >= 3);
    }
}