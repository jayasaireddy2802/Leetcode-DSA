class Solution {
    public int minCost(String colors, int[] neededTime) {
        int len = neededTime.length;
        int ans = 0;
        char prev = colors.charAt(0);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(neededTime[0]);

        for(int i = 1; i < len; i++)
        {
            if(colors.charAt(i) == prev)
            {
                pq.add(neededTime[i]);
            }
            else
            {
                int val = 0;
                int res = 0;

                while(!pq.isEmpty())
                {
                    val = pq.poll();
                    res = res + val;
                }

                res = res - val;
                ans = ans + res;

                pq.clear();
                pq.add(neededTime[i]);
            }

            prev = colors.charAt(i);
        }

        int val = 0;
        int res = 0;
        while(!pq.isEmpty())
        {
            val = pq.poll();
            res = res + val;
        }

        res = res - val;
        ans = ans + res;

        return ans;
    }
}