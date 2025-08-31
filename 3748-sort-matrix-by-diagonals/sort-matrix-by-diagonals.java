class Solution {
    private void sortDiagonal(int r, int c, int[][] grid, boolean descending)
    {   
        List<Integer> list = new ArrayList<>();
        int n = grid.length;
        int i = r;
        int j = c;

        while(i < n && j < n)
        {
            list.add(grid[i][j]);
            i++;
            j++;
        }

        if(descending)
            Collections.sort(list, Collections.reverseOrder());
        else
            Collections.sort(list);

        i = r; j = c;

        for(int num : list)
        {
            grid[i][j] = num;
            i++;
            j++;
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        
        int n = grid.length;

        // descending order diagonal sort bottom-left triangle
        for(int row = 0; row < n; row++)
        {
            sortDiagonal(row, 0, grid, true);
        }

        // acending order diagonal sort top-right triangle
        for(int col = 1; col < n; col++)
        {
            sortDiagonal(0, col, grid, false);
        }        

        return grid;
    }
}