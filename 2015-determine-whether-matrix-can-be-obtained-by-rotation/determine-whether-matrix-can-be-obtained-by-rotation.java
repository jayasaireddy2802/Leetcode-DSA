class Solution {

    public void rotate(int[][] mat)
    {
        int rows = mat.length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = i; j < rows; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < rows/2; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[i][rows - j - 1];
                mat[i][rows - j - 1] = temp;
            }
        }
    }

    public boolean isEqual(int[][] mat, int[][] target)
    {
        int rows = mat.length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < rows; j++)
            {
                if(mat[i][j] != target[i][j])
                    return false;
            }
        }

        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++)
        {
            rotate(mat);
            if(isEqual(mat, target))
                return true;
        }

        return false;
    }
}