class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        List<List<Integer>> list = new ArrayList<>();
        int[] ans = new int[m * n];
        int j = 0;

        for(int i = 1; i < m + n; i++)
            list.add(new ArrayList());

        for(int i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                list.get(i + j).add(mat[i][j]);
            }
        }

        j = 0;

        for(int i = 0; i < m + n - 1; i++)
        {
            if(i % 2 == 0)
            {
                int size = list.get(i).size();
                for(int k = size - 1; k >= 0; k--)
                {
                    ans[j++] = list.get(i).get(k);
                }
            }
            else
            {
                for(int num : list.get(i))
                {
                    ans[j++] = num;
                }   
            }
        }

        return ans;
    }
}