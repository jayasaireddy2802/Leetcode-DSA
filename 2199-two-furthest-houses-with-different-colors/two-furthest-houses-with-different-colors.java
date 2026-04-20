class Solution {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        int maxi = 0;
        
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(colors[i] != colors[j])
                    maxi = Math.max(maxi, j - i);
            }
        }

        return maxi;
    }
}