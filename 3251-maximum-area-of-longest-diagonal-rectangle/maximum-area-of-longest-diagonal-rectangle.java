class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double ans = 0;
        int max_len = 0;
        int max_width = 0;
        int area = 0;

        for(int[] dimension : dimensions)
        {
            int a = dimension[0];
            int b = dimension[1];
            double c = Math.sqrt(a*a + b*b);
            
            if(c > ans)
            {
                ans = c;
                max_len = a;
                max_width = b;
                area = a*b;
            }
            else if(c == ans)
            {
                area = Math.max(a*b, area);
            }
        }
        return area;
    }
}