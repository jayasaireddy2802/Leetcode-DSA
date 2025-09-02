class Solution {
    public int numberOfPairs(int[][] points) {
        int len = points.length;
        int ans = 0;

        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if(i == j)
                    continue;
                boolean flag = true;

                int upperLeftX = points[i][0];
                int upperLeftY = points[i][1];

                int bottomRightX = points[j][0];
                int bottomRightY = points[j][1];

                if(upperLeftX > bottomRightX || upperLeftY < bottomRightY)
                    continue;
                
                    for(int k = 0; k < len; k++)
                    {
                        if(k == i || k == j)
                            continue;
                        
                        int kx = points[k][0];
                        int ky = points[k][1];

                        if((kx >= upperLeftX && kx <= bottomRightX) && (ky <= upperLeftY && ky >= bottomRightY))
                        {
                            flag = false;
                            break;
                        }
                    }
                

                if(flag)
                    ans++;
            }
        }

        return ans;
    }
}