// class Solution {

//     private void fillArray(int x, int y, int[] arr, int[][] mat)
//     {
//         int m = mat.length;
//         int n = mat[0].length;

//         for(int j = 0; j < n; j++)
//         {
//             int val = 1;
//             for(int i = x; i <= y; i++)
//             {
//                 val = (val & mat[i][j]);
//             }
//             arr[j] = val;
//         }
//     }

//     private int count(int[] mat)
//     {
//         int ans = 0;
//         int ct = 0;
//         int len = mat.length;

//         for(int i = 0; i < len; i++)
//         {
//             if(mat[i] == 1)
//                 ct++;
//             else
//                 ct = 0;
//             ans = ans + ct;
//         }

//         return ans;
//     }

//     public int numSubmat(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int ans = 0;

//         for(int i = 0; i < m; i++)
//         {
//             for(int j = i; j < m; j++)
//             {
//                 int[] arr = new int[n];
//                 fillArray(i, j, arr, mat);
//                 ans = ans + count(arr);
//             }
//         }

//         return ans;
//     }
// }


class Solution {

    private void fillArray(int x, int[] arr, int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        for(int j = 0; j < n; j++)
        {
            arr[j] = (arr[j] & mat[x][j]);
        }
    }

    private int count(int[] mat)
    {
        int ans = 0;
        int ct = 0;
        int len = mat.length;

        for(int i = 0; i < len; i++)
        {
            if(mat[i] == 1)
                ct++;
            else
                ct = 0;
            ans = ans + ct;
        }

        return ans;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        for(int i = 0; i < m; i++)
        {
            int[] arr = new int[n];
            Arrays.fill(arr, 1);
            for(int j = i; j < m; j++)
            {
                fillArray(j, arr, mat);
                ans = ans + count(arr);
            }
        }

        return ans;
    }
}