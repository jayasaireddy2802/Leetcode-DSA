class Solution {
    public int[] sumZero(int n) {
        int val = n/2;
        int[] ans = new int[n];
        int idx = 0;

        for(int i = -1 * val; i < 0; i++)
        {
            ans[idx++] = i;
        }

        int start = (n%2 == 0) ? 1 : 0;
        for(int i = start; i <= val; i++)
        {
            ans[idx++] = i;
        }

        return ans;
    }
}