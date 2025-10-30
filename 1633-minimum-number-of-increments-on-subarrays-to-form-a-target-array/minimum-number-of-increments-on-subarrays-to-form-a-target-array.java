class Solution {
    public int minNumberOperations(int[] target) {
        int ans = 0;
        int prev = 0;
        int len = target.length;

        for(int i = 0; i < len; i++)
        {
            if(target[i] > prev)
            {
                ans = ans + (target[i] - prev);
            }
            prev = target[i];
        }

        return ans;
    }
}