class Solution {

    public boolean isSpecial(int row, int col, int[][] mat)
    {
        int rows = mat.length;
        int cols = mat[0].length;

        for(int i = 0; i < rows; i++)
        {
            if(i != row && mat[i][col] == 1)
                return false;
        }

        for(int i = 0; i < cols; i++)
        {
            if(i != col && mat[row][i] == 1)
                return false;
        }

        return true;
    }

    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int ans = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(mat[i][j] == 1 && isSpecial(i, j, mat))
                {
                    ans++;
                }
            }
        }

        return ans;

    }
}