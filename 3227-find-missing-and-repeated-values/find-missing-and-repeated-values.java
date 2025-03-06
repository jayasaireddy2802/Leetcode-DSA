class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int l = n*n;
        int[] ans = new int[2];
        boolean[] visited = new boolean[l+1];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(visited[grid[i][j]] == false)
                    visited[grid[i][j]] = true;
                else
                    ans[0] = grid[i][j];
            }
        }

        for(int i = 1; i <= l; i++)
        {
            if(visited[i] == false)
            {
                ans[1] = i;
                return ans;
            }
        }

        return ans;
    }
}