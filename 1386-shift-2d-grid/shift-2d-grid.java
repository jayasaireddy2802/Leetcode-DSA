class Solution {

    public void reverse(int i, int j, int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        while(i < j)
        {
            int temp = grid[i / cols][i % cols];
            grid[i / cols][i % cols] = grid[j / cols][j % cols];
            grid[j / cols][j % cols] = temp;
            i++;
            j--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        k = k % n;

        reverse(0, n - 1, grid);
        reverse(0, k - 1, grid);
        reverse(k, n - 1, grid);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < rows; i++)
        {
            List<Integer> l = new ArrayList<>();

            for(int j = 0; j < cols; j++)
            {
                l.add(grid[i][j]);
            }

            list.add(l);
        }

        return list;
    }
}