class Solution {

    public int getMinimumDifference(int row, int col, int[][] grid, int k)
    {
        List<Integer> list = new ArrayList<>();

        for(int i = row; i < row + k; i++)
        {
            for(int j = col; j < col + k; j++)
            {
                list.add(grid[i][j]);
            }
        }

        int len = list.size();
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if(i != j && (!list.get(i).equals(list.get(j))))
                    mini = Math.min(Math.abs(list.get(i) - list.get(j)), mini);
            }
        }

        return (mini == Integer.MAX_VALUE) ? 0 : mini;
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ans = new int[rows - k + 1][cols - k + 1];

        for(int i = 0; i < rows - k + 1; i++)
        {
            for(int j = 0; j < cols - k + 1; j++)
            {
                int num = getMinimumDifference(i, j, grid, k);
                ans[i][j] = num;
            }
        }

        return ans;
    }
}