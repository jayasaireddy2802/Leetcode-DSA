class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = i; j < rows; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int k = 0; k < rows; k++)
        {
            int i = 0;
            int j = rows - 1;

            while(i < j)
            {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                j--;
            }
        }
    }
}