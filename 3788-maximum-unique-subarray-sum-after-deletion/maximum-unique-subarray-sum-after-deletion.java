class Solution {
    public int maxSum(int[] nums) {
        boolean[] visited = new boolean[101];
        int mini = Integer.MIN_VALUE;
        int sum = 0;
        int ct = 0;
        int len = nums.length;
        for(int num : nums)
        {
            if(num >= 0 && (!visited[num]))
            {
                sum += num;
                visited[num] = true;
            }
            else
            {
                ct++;
                mini = Math.max(mini, num);
            }
        }

        if(ct == len)
            return mini;
        else
            return sum;
    }
}