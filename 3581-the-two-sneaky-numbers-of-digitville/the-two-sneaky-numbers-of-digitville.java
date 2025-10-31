class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[101];
        int[] ans = new int[2];
    
        for(int num : nums)
        {
            if(visited[num])
            {
                if(ans[0] == 0)
                    ans[0] = num;
                else
                    ans[1] = num;
            }
            visited[num] = true;
        }

        return ans;
    }
}