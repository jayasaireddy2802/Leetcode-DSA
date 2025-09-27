class Solution {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double max_area = 0;

        for(int i = 0; i < len - 2; i++)
        {
            for(int j = i + 1; j < len - 1; j++)
            {
                for(int k = j + 1; k < len; k++)
                {
                    int x1 = points[i][0];
                    int x2 = points[j][0];
                    int x3 = points[k][0];

                    int y1 = points[i][1];
                    int y2 = points[j][1];
                    int y3 = points[k][1];

                    double base = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
                    double numerator = Math.abs((y2 - y1) * x3 - (x2 - x1) * y3 + (x2*y1 - y2*x1));
                    double denominator = Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
                    double height = numerator / denominator;

                    double area = (base * height) / 2;
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }
}