class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        // Arrays.fill(leftToRight, 1);
        // Arrays.fill(rightToLeft, 1);
        int ans = 0;
        leftToRight[0] = 1;
        rightToLeft[len-1] = 1;

        for(int i = 1; i < len; i++)
        {
            if(ratings[i] > ratings[i-1])
                leftToRight[i] = leftToRight[i - 1] + 1;
            else
                leftToRight[i] = 1;
        }

        for(int i = len - 2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i+1])
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            else
                rightToLeft[i] = 1;
        }

        for(int i = 0; i < len; i++)
            ans += Math.max(leftToRight[i], rightToLeft[i]);

        return ans;
    }
}