class Solution {
    public int numberOfPairs(int[][] points) {
        int len = points.length;
        // int i = 0, j = 0;
        int ans = 0;

        Arrays.sort(points, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);

        for(int i = 0; i < len; i++)
        {
            int topLeftX = points[i][0];
            int topLeftY = points[i][1];
            
            int maxY = Integer.MIN_VALUE;
            for(int j = i + 1; j < len; j++)
            {
                int bottomRightX = points[j][0];
                int bottomRightY = points[j][1];

                if(bottomRightY > topLeftY)
                    continue;
                
                if(bottomRightY > maxY)
                {
                    ans++;
                    maxY = bottomRightY;
                }
            }
        }

        return ans;
    }
}