class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        char[] hori = {'E', 'W'};
        char[] ver = {'N', 'S'};

        for(char x : ver)
        {
            for(char y : hori)
            {
                int val = 0;
                int remaining = k;
                for(char ch : s.toCharArray())
                {
                    if(ch == x || ch == y)
                    {
                        val++;
                    }
                    else if(remaining > 0)
                    {
                        val++;
                        remaining--;
                    }
                    else
                        val--;

                    ans = Math.max(val, ans);
                }
            }
        }

        return ans;
    }
}