class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> num = new PriorityQueue<>();
        List<Long> res = new ArrayList<>();
        int ct = 0;
        for(int x : nums)
        {
            if(x >= k)
                res.add((long)x);
            else
                num.add((long)x);
        }
        while(num.size() >= 2)
        {
            long x = num.poll();
            long y = num.poll();
            long val = Math.min(x, y) * 2 + Math.max(x, y);
            if(val < k)
            num.add(val);
            ct++;
        }
        if(num.size() == 1)
            ct++;
        return ct;
    }
}