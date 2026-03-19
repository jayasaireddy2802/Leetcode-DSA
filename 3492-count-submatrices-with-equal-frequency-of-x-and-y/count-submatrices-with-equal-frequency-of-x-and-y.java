class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        int[][][] prefixMatrix = new int[rows + 1][cols + 1][2];

        for(int i = 1; i <= rows; i++)
        {
            for(int j = 1; j <= cols; j++)
            {
                int[] arr1 = prefixMatrix[i - 1][j];
                int[] arr2 = prefixMatrix[i][j - 1];
                int[] arr3 = prefixMatrix[i - 1][j - 1];
                int[] nums = new int[2];

                if(grid[i - 1][j - 1] == 'X')
                {
                    nums[0] = 1 + arr1[0] + arr2[0] - arr3[0];
                    nums[1] = arr1[1] + arr2[1] - arr3[1];
                } 
                else if(grid[i - 1][j - 1] == 'Y')
                {
                    nums[0] = arr1[0] + arr2[0] - arr3[0];
                    nums[1] = 1 + arr1[1] + arr2[1] - arr3[1];
                }
                else
                {
                    nums[0] = arr1[0] + arr2[0] - arr3[0];
                    nums[1] = arr1[1] + arr2[1] - arr3[1];
                }

                prefixMatrix[i][j] = nums;
                if(prefixMatrix[i][j][0] != 0 && (prefixMatrix[i][j][0] == prefixMatrix[i][j][1]))
                    ans++;
            }
        }

        return ans;
    }
}